package com.MovieBooking.Movie_Service.Controller;

import com.MovieBooking.Movie_Service.Entity.Booking;
import com.MovieBooking.Movie_Service.Entity.BookingRequest;
import com.MovieBooking.Movie_Service.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request){
        return new ResponseEntity<>(bookingService.createBooking(request), HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<List<Booking>>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getBookingByUserId(@PathVariable String username){
       if(!bookingService.getByUserId(username).isEmpty()){
           return new ResponseEntity<List<Booking>>(bookingService.getByUserId(username), HttpStatus.OK);
       }
       return new ResponseEntity<>("No Bookings available", HttpStatus.NO_CONTENT);
    }

}
