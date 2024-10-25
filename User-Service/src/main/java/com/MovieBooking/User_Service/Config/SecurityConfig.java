package com.MovieBooking.User_Service.Config;

import com.MovieBooking.User_Service.Entity.Role;
import com.MovieBooking.User_Service.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserServiceImpl userService;

    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests(req -> req
                        .requestMatchers("/api/v1/users/login").authenticated()
                        .requestMatchers("/api/v1/users/**").permitAll()
                        .requestMatchers("/api/v1/users/getAllUsers").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
