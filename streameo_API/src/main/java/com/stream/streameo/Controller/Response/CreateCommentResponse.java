package com.stream.streameo.Controller.Response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class CreateCommentResponse {
    private String commentContent;
    private String userIp;
    private int movieId;
}
