package de.frostforge.backend.manga.repository;

import de.frostforge.backend.anime.repository.AnimeEntity;
import de.frostforge.backend.chapter.repository.ChapterEntity;
import de.frostforge.backend.character.repository.CharacterEntity;
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
public class MangaEntity {
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

    // many to many
    @Column
    private List<CharacterEntity> characters;

    // one to many
    @Column
    private List<ChapterEntity> chapters;

    @Column
    private String medium;
}
