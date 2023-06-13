package com.stream.streameo.Controller;

import com.stream.streameo.Controller.Mapper.LikeMapper;
import com.stream.streameo.Controller.Response.CreateLikeResponse;
import com.stream.streameo.Entity.LikeEntity;
import com.stream.streameo.Service.LikeService;
import io.micrometer.core.instrument.config.validate.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class LikeController {
    private final LikeService likeService;
    private final LikeMapper createLikeMapper;


    @PostMapping("/like")
    public ResponseEntity<?> like (@RequestBody CreateLikeResponse createLikeResponse) {
        try {
            LikeEntity like = createLikeMapper.toDomain(createLikeResponse);
            likeService.like(like);
            return ResponseEntity.status(HttpStatus.CREATED).body("Like créé avec succès.");
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la création du like.");
        }
    }


    @DeleteMapping("/unLike")
    public ResponseEntity<?> unLike (@RequestBody LikeEntity like) {
        try {
            likeService.unlike(like);
            return ResponseEntity.status(HttpStatus.OK).body("Like supprimé avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression du like.");
        }
    }

}
