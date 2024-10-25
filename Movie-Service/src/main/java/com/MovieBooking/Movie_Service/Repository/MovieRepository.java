package com.MovieBooking.Movie_Service.Repository;

import com.MovieBooking.Movie_Service.Entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Long> {
    Optional<Movie> findByMovieId(String movieId);
}
