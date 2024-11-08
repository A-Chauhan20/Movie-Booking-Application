package com.MovieBooking.User_Service.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

public class Booking {
    private String bookingId;
    //private String username;
    private String movieId;
    private String movieTitle;
    private String genre;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    private int seatsToBook;
    private LocalDateTime bookingTime;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

//    //public String getUsername() {
//        return username;
//    }

//  //  public void setUsername(String username) {
//        this.username = username;
//    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getSeatsToBook() {
        return seatsToBook;
    }

    public void setSeatsToBook(int seatsToBook) {
        this.seatsToBook = seatsToBook;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
