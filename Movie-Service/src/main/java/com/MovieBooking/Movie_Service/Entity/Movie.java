package com.MovieBooking.Movie_Service.Entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
public class Movie {
    @Id
    private String movieId;
    private String title;
    private String genre;
    private int totalSeats;
    private int availableSeats;

    public Movie(String title, String genre, int totalSeats, int availableSeats, String movieId) {

        this.title = title;
        this.genre = genre;
        this.movieId = movieId;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getMovieId() {
        return movieId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}
