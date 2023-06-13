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
@Table(indexes = @Index(columnList = "movie_entity_movie_id"),name = "likes",uniqueConstraints = {@UniqueConstraint(columnNames = {"ip_user", "movie_entity_movie_id"})})
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_entity_movie_id")
    private MovieEntity movieEntity;

    @Column(name = "ip_user",nullable = false)
    private String ipUser;
}
