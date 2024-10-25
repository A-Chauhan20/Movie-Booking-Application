package com.MovieBooking.Movie_Service.Service;

import com.MovieBooking.Movie_Service.Entity.Booking;
import com.MovieBooking.Movie_Service.Entity.BookingRequest;
import com.MovieBooking.Movie_Service.Entity.Movie;
import com.MovieBooking.Movie_Service.Repository.BookingRepository;
import com.MovieBooking.Movie_Service.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Booking createBooking(BookingRequest booking) {
        Optional<Movie> movieExists = movieRepository.findByMovieId(booking.getMovieId());
        if(movieExists.isEmpty()){
            throw new RuntimeException("Movie Does not Exists");
        }
        Movie movie = movieExists.get();
        if(booking.getSeatsToBook() > movie.getAvailableSeats()){
            throw new RuntimeException("Not enough seats");
        }
        System.out.println(movie.getAvailableSeats());
        movie.setAvailableSeats(movie.getAvailableSeats() - booking.getSeatsToBook());
        System.out.println(movie.getAvailableSeats());
        movieRepository.save(movie);
        Booking booking1 = new Booking();
        booking1.setUserId(booking.getUserId());
        booking1.setMovieId(movie.getMovieId());
        booking1.setMovieTitle(movie.getTitle());
        booking1.setBookingTime(LocalDateTime.now());
        booking1.setGenre(movie.getGenre());
        booking1.setSeatsToBook(booking.getSeatsToBook());
        return bookingRepository.save(booking1);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }

}
