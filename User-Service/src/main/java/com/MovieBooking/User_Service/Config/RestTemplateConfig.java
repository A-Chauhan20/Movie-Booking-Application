package com.MovieBooking.User_Service.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(authInterceptor()));
        return restTemplate;
    }


    private ClientHttpRequestInterceptor authInterceptor(){
        return (request, body, execution) -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication != null && authentication.getCredentials() instanceof String){
                String token = (String) authentication.getCredentials();
                request.getHeaders().add("Authorization", "Bearer "+token);
            }
            return execution.execute(request, body);
        };

    }



}
