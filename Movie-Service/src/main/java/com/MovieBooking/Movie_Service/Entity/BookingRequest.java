package com.MovieBooking.Movie_Service.Entity;

public class BookingRequest {
    private String movieId;
    private String username;
    private int seatsToBook;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSeatsToBook() {
        return seatsToBook;
    }

    public void setSeatsToBook(int seatsToBook) {
        this.seatsToBook = seatsToBook;
    }
}
