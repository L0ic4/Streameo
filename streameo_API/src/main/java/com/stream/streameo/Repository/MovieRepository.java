package com.stream.streameo.Repository;

import com.stream.streameo.Entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    List<MovieEntity> findMovieEntitiesByMovieTitleContainingIgnoreCase(String movieTitle);

}
