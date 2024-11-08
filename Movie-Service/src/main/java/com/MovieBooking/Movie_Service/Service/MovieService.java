package com.MovieBooking.Movie_Service.Service;

import com.MovieBooking.Movie_Service.Entity.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {
    Movie createMovie(Movie Movie);
    List<Movie> getAllMovies();
    Optional<Movie> getById(Long movieId);
    Movie updateMovie(Long movieId, Movie movie);
    boolean deleteMovie(String movieId);
}
