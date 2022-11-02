package de.frostforge.backend.anime.repository;

import de.frostforge.backend.actor.repository.ActorEntity;
import de.frostforge.backend.character.repository.CharacterEntity;
import de.frostforge.backend.episode.repository.EpisodeEntitiy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table
public class AnimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String japTitle;

    @Column
    private String englishTitle;

    @Column
    private String synonym;

    // many to many
    @Column
    private List<GenreEntity> genres;

    // many to many
    @Column
    private List<TagEntity> tags;

    // one to many
    @Column
    private List<AnimeEntity> adaption;

    // many to many
    @Column
    private List<PSKEntity> psks;

    @Column
    private LocalDate seasonStart;

    @Column
    private LocalDate seasonEnd;

    // many to many
    @Column
    private StatusEntity status;

    // many to many
    @Column
    private List<GroupEntity> groups;

    // many to many
    @Column
    private List<CompanyEntity> companies;

    @Column
    private String license;

    @Column
    private String description;

    // one to many
    @Column
    private List<RatingEntity> ratings;

    @Column
    private String thumbnail;

    @Column
    private String trailer;

    // many to many
    @Column
    private List<ActorEntity> actors;

    // many to many
    @Column
    private List<CharacterEntity> characters;

    // one to many
    @Column
    private List<EpisodeEntitiy> episodes;

    @Column
    private String medium;
}
