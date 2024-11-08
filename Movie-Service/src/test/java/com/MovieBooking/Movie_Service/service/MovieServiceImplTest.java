package com.MovieBooking.Movie_Service.service;

import com.MovieBooking.Movie_Service.Entity.Movie;
import com.MovieBooking.Movie_Service.Repository.MovieRepository;
import com.MovieBooking.Movie_Service.Service.MovieServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class MovieServiceImplTest {
    @Mock
    private MovieRepository movieRepository;
    @InjectMocks
    private MovieServiceImpl movieService;

    private Movie testMovie;
    private Movie testMovie1;

    @BeforeEach
    void setUp(){

        testMovie = new Movie("James Bond","action",100,100,"1001");
        testMovie1 = new Movie("Avengers","action",100,100,"1002");
    }
    @Test
    void createMovieTest(){
        when(movieRepository.findByMovieId("1001")).thenReturn(Optional.empty());
        when(movieRepository.save(testMovie)).thenReturn(testMovie);
        Movie createdMovie = movieService.createMovie(testMovie);
        Assertions.assertNotNull(createdMovie);
        Assertions.assertEquals(testMovie.getMovieId(), createdMovie.getMovieId());
        verify(movieRepository, times(1)).save(testMovie);
    }

    @Test
    void movieAlreadyExistsTest(){
        when(movieRepository.findByMovieId(testMovie.getMovieId())).thenReturn(Optional.of(testMovie));
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,
                ()->movieService.createMovie(testMovie));
        //System.out.println(exception.getMessage());
        Assertions.assertEquals("Movie Already exist",exception.getMessage());
        verify(movieRepository, never()).save(testMovie);
    }

    @Test
    void getAllMoviesTest(){
        when(movieRepository.findAll()).thenReturn(List.of(testMovie, testMovie1));
        List<Movie> movieList = movieService.getAllMovies();
        Assertions.assertEquals(2, movieList.size());
        Assertions.assertTrue(movieList.contains(testMovie));
        Assertions.assertTrue(movieList.contains(testMovie1));
        verify(movieRepository, times(1)).findAll();
    }

    @Test
    void deleteMovieTest(){
        when(movieRepository.findByMovieId(testMovie.getMovieId())).thenReturn(Optional.of(testMovie));
        boolean result = movieService.deleteMovie(testMovie.getMovieId());
        Assertions.assertTrue(result);
        verify(movieRepository, times(1)).findByMovieId(testMovie.getMovieId());
        verify(movieRepository, times(1)).deleteById(Long.parseLong(testMovie.getMovieId()));
    }

}
