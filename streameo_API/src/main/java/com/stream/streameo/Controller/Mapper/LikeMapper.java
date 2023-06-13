package com.stream.streameo.Controller.Mapper;

import com.stream.streameo.Controller.Response.CreateLikeResponse;
import com.stream.streameo.Entity.LikeEntity;
import com.stream.streameo.Entity.MovieEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LikeMapper {
    public LikeEntity toDomain (CreateLikeResponse createLikeResponse) {
        return LikeEntity.builder()
                .ipUser(createLikeResponse.getUserIp())
                .movieEntity(MovieEntity.builder()
                        .movieId(createLikeResponse.getMovieId())
                                .build())
                .build();
    }
}
