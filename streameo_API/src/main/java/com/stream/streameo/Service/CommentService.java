package com.stream.streameo.Service;

import com.stream.streameo.Entity.CommentEntity;
import com.stream.streameo.Repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    public void addComment(CommentEntity commentEntity){
        commentRepository.save(commentEntity);
    }

    public List<CommentEntity> getCommentByMovieId(int movieId){
       return commentRepository.findCommentEntitiesByMovieEntity_MovieId(movieId);
    }
}
