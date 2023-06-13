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
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(nullable = false)
    private String movieTitle;
    @Column(nullable = false)
    private String movieDescription;
    @Column(nullable = false)
    private String movieLink;
    @Column(nullable = false)
    private String movieCover;
}
