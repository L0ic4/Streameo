package com.stream.streameo.Repository;

import com.stream.streameo.Entity.DislikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DislikeRepository extends JpaRepository<DislikeEntity, Integer> {
    int countByMovieEntityMovieId(int movieId);
}
