package com.MovieBooking.Movie_Service.Entity;

public class BookingRequest {
    private String movieId;
    private String userId;
    private int seatsToBook;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSeatsToBook() {
        return seatsToBook;
    }

    public void setSeatsToBook(int seatsToBook) {
        this.seatsToBook = seatsToBook;
    }
}
