package com.MovieBooking.Movie_Service.Repository;

import com.MovieBooking.Movie_Service.Entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, Long> {
    List<Booking> findByUsername(String username);
}
