package de.frostforge.backend.rating.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table
public class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private User author;

    @Column
    private Integer genreRating;

    @Column
    private Integer storyRating;

    @Column
    private Integer animationRating;

    @Column
    private Integer characterRating;

    @Column
    private Integer musicRating;

    @Column
    private Integer overallRating;

    @Column
    private String comment;
}
