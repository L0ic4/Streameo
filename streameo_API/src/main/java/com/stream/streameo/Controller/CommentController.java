package com.stream.streameo.Controller;
import com.stream.streameo.Controller.Mapper.CommentMapper;
import com.stream.streameo.Controller.Response.CommentResponse;
import com.stream.streameo.Controller.Response.CreateCommentResponse;
import com.stream.streameo.Entity.CommentEntity;
import com.stream.streameo.Service.CommentService;
import io.micrometer.core.instrument.config.validate.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @PostMapping("/comment")
    private ResponseEntity<String> addComment (@RequestBody CreateCommentResponse createCommentResponse){
        try {
            CommentEntity commentEntity = commentMapper.toDomain(createCommentResponse);
            commentService.addComment(commentEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body("Commentaire ajouté avec succès.");
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du commentaire.");
        }
    }

    @GetMapping("/comments/{movieId}")
    private ResponseEntity<?> getAllCommentByMovie(@PathVariable int movieId){
        try {
            List<CommentEntity> commentEntities = commentService.getCommentByMovieId(movieId);
            List<CommentResponse> commentResponses = commentEntities.stream().map(commentMapper::toRest).toList();
            return ResponseEntity.status(HttpStatus.OK).body(commentResponses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération des commentaires.");
        }
    }

}
