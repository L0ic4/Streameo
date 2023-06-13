package com.stream.streameo.Controller.Mapper;

import com.stream.streameo.Controller.Response.CreateDislikeResponse;
import com.stream.streameo.Entity.LikeEntity;
import com.stream.streameo.Entity.MovieEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DislikeMapper {
    public LikeEntity toDomain (CreateDislikeResponse createDislikeResponse) {
        return LikeEntity.builder()
                .ipUser(createDislikeResponse.getUserIp())
                .movieEntity(MovieEntity.builder()
                        .movieId(createDislikeResponse.getMovieId())
                        .build())
                .build();
    }
}
