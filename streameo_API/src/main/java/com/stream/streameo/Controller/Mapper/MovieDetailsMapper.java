package com.stream.streameo.Controller.Mapper;

import com.stream.streameo.Controller.Response.MovieDetailsResponse;
import com.stream.streameo.Entity.MovieEntity;
import com.stream.streameo.Service.DislikeService;
import com.stream.streameo.Service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieDetailsMapper {
private LikeService likeService;

private DislikeService dislikeService;


    public MovieDetailsResponse toRest (MovieEntity movieEntity){
        int numberOfLike = likeService.getLikeNumber(movieEntity.getMovieId());
        int numberOfDislike = dislikeService.getDislikeNumber(movieEntity.getMovieId());
        return MovieDetailsResponse.builder()
                .movieId(movieEntity.getMovieId())
                .movieTitle(movieEntity.getMovieTitle())
                .movieCover(movieEntity.getMovieCover())
                .movieDescription(movieEntity.getMovieDescription())
                .movieLink(movieEntity.getMovieLink())
                .numberOfLikes(numberOfLike)
                .numberOfDislikes(numberOfDislike)
                .build();

    }
}
