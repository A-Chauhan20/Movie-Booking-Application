package com.MovieBooking.User_Service.Service;

import com.MovieBooking.User_Service.Entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MyBooking {
    @Autowired
    private RestTemplate restTemplate;

    private static final String MOVIE_SERVICE_URL = "http://localhost:8080/api/v1/booking/";

    public String getCurrentUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof User user){

            return user.getUsername();
        }
        return null;
    }

    public List<Booking> myBookings(){
        String username = getCurrentUserName();
        System.out.println(username);
        if(username != null){
            String URL = MOVIE_SERVICE_URL +username;
            return restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Booking>>() {
            }).getBody();
        }

        return null;
    }
}
