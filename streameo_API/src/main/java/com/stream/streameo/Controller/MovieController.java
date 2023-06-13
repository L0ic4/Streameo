package com.stream.streameo.Controller;

import com.stream.streameo.Controller.Mapper.MovieDetailsMapper;
import com.stream.streameo.Controller.Response.MovieDetailsResponse;
import com.stream.streameo.Entity.MovieEntity;
import com.stream.streameo.Service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final MovieDetailsMapper movieDetailsMapper;

    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovies() {
        try {
            List<MovieEntity> movies = movieService.getAllMovie();
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération des films.");
        }
    }

    @GetMapping("/movies/{name}")
    public ResponseEntity<?> getAllMoviesByName(@PathVariable String name) {
        try {
            List<MovieEntity> movies = movieService.getMovieByTitle(name);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération des films.");
        }
    }

    @GetMapping("/movie/random")
    public ResponseEntity<?> getRandomMovie () {
        try {
            MovieEntity movieEntity = movieService.getRandomMovie();
            MovieDetailsResponse movieDetailsResponse = movieDetailsMapper.toRest(movieEntity);
            return ResponseEntity.ok(movieDetailsResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération d'un film au hasard.");
        }
    }


    @GetMapping("/movie/{id}")
    public MovieDetailsResponse getMoviesById(@PathVariable int id){
        MovieEntity movieEntity = movieService.getMovieById(id);
        return movieDetailsMapper.toRest(movieEntity);
    }
}
