package com.stream.streameo.Repository;

import com.stream.streameo.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
    List<CommentEntity> findCommentEntitiesByMovieEntity_MovieId(int movieId);
}
