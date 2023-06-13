package com.stream.streameo.Service;

import com.stream.streameo.Entity.MovieEntity;
import com.stream.streameo.Repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<MovieEntity> getAllMovie(){
        return movieRepository.findAll();
    }

    public List<MovieEntity> getMovieByTitle(String title) {
        return movieRepository.findMovieEntitiesByMovieTitleContainingIgnoreCase(title);
    }

    public MovieEntity getMovieById (int id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        return movieEntity.orElse(null);
    }

    public MovieEntity getRandomMovie (){
       int totalMovie = (int) movieRepository.count();
        Random rand = new Random();
        int randomId = rand.nextInt(totalMovie - 1) + 1;
        return getMovieById(randomId);
    }

}
