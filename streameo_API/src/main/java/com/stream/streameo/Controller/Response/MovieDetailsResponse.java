package com.stream.streameo.Controller.Response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class MovieDetailsResponse {
    private int movieId;
    private String movieTitle;
    private String movieDescription;
    private String movieLink;
    private String movieCover;
    private int numberOfLikes;
    private int numberOfDislikes;
}
