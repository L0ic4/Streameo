package com.stream.streameo.Repository;

import com.stream.streameo.Entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LikeRepository extends JpaRepository<LikeEntity,Integer> {
    int countByMovieEntityMovieId(int movieId);
}
