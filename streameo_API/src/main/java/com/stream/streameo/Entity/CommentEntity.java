package com.stream.streameo.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comments",indexes = @Index(columnList = "movie_entity_movie_id"))
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(nullable = false)
    private String commentContent;

    @Column(name = "ip_user",nullable = false)
    private String ipUser;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_entity_movie_id")
    private MovieEntity movieEntity;
}
