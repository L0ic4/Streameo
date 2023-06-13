package com.stream.streameo.Controller.Response;

import com.stream.streameo.Entity.CommentEntity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class CommentResponse {
    private int commentId;
    private String commentContent;
}
