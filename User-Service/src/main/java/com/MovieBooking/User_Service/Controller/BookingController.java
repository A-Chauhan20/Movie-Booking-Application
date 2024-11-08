package com.MovieBooking.User_Service.Controller;

import com.MovieBooking.User_Service.Service.MyBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/user-bookings")
public class BookingController {

    @Autowired
    private MyBooking myBooking;
    @GetMapping("/my-booking")
    public ResponseEntity<?> myBookings(){
        System.out.println(myBooking.getCurrentUserName());
        return new ResponseEntity<>(myBooking.myBookings(), HttpStatus.OK);
    }
}
