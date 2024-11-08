package com.MovieBooking.Movie_Service.Controller;

import com.MovieBooking.Movie_Service.Entity.Movie;
import com.MovieBooking.Movie_Service.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<?> createMovie(@RequestBody Movie movie) {
        Movie movie1 = null;
        try {
            if (movie != null) {
                movie1 = movieService.createMovie(movie);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Movie creation failed", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(movie1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);

    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<Movie>> getById(@PathVariable Long movieId){
        return new ResponseEntity<>(movieService.getById(movieId), HttpStatus.OK);
    }
    @PutMapping("/{movieId}")
    public ResponseEntity<?> updateMovie(@PathVariable Long movieId, @RequestBody Movie movie){
        return new ResponseEntity<>(movieService.updateMovie(movieId, movie), HttpStatus.OK);
    }
    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable String movieId){
        if(movieService.deleteMovie(movieId)){
            return new ResponseEntity<>("Movie Deleted Successfully", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Movie does not exist", HttpStatus.BAD_REQUEST);
    }

}
