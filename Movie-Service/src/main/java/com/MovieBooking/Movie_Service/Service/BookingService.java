package com.MovieBooking.Movie_Service.Service;

import com.MovieBooking.Movie_Service.Entity.Booking;
import com.MovieBooking.Movie_Service.Entity.BookingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    Booking createBooking(BookingRequest booking);
    List<Booking> getAllBookings();
    List<Booking> getByUserId(String userId);
}
