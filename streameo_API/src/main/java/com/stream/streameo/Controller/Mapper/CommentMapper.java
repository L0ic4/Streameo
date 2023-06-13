package com.stream.streameo.Controller.Mapper;

import com.stream.streameo.Controller.Response.CommentResponse;
import com.stream.streameo.Controller.Response.CreateCommentResponse;
import com.stream.streameo.Entity.CommentEntity;
import com.stream.streameo.Entity.MovieEntity;
import com.stream.streameo.Service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CommentMapper {
private CommentService commentService;
    public CommentEntity toDomain (CreateCommentResponse createCommentResponse){
        return CommentEntity.builder()
                .commentContent(createCommentResponse.getCommentContent())
                .ipUser(createCommentResponse.getUserIp())
                .movieEntity(MovieEntity.builder()
                        .movieId(createCommentResponse.getMovieId())
                        .build())
                .build();
    }
    public CommentResponse toRest (CommentEntity commentEntity){
        List<CommentEntity> comments = commentService.getCommentByMovieId(commentEntity.getMovieEntity().getMovieId());
        return CommentResponse.builder()
                .commentId(commentEntity.getCommentId())
                .commentContent(commentEntity.getCommentContent())
                .build();
    }
}
