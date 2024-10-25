package com.MovieBooking.Movie_Service.Service;

import com.MovieBooking.Movie_Service.Entity.Movie;
import com.MovieBooking.Movie_Service.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Movie createMovie(Movie movie) {
        Optional<Movie> movieExist = movieRepository.findByMovieId(movie.getMovieId());
       try{
           if(movieExist.isPresent()){
              throw new RuntimeException("Movie Already exist");
           }
           else return movieRepository.save(movie);
       }
       catch(Exception e){
           throw new RuntimeException(e);
       }


    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getById(Long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public Movie updateMovie(Long movieId, Movie movie) {
        Movie existingMovie = movieRepository.
                findById(movieId).orElseThrow(()-> new RuntimeException("Movie Not Found"));
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setTotalSeats(movie.getTotalSeats());
        existingMovie.setAvailableSeats(movie.getAvailableSeats());
        return movieRepository.save(existingMovie);
    }

    @Override
    public boolean deleteMovie(Long movieId) {
        if(movieRepository.findById(movieId).isPresent()){
            movieRepository.deleteById(movieId);
            return true;
        }
        else return false;
    }
}
