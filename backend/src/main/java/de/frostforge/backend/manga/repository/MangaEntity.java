package de.frostforge.backend.manga.repository;

import de.frostforge.backend.anime.repository.AnimeEntity;
import de.frostforge.backend.chapter.repository.ChapterEntity;
import de.frostforge.backend.character.repository.CharacterEntity;
import de.frostforge.backend.company.repository.CompanyEntity;
import de.frostforge.backend.genre.repository.GenreEntity;
import de.frostforge.backend.group.repository.GroupEntity;
import de.frostforge.backend.psk.repository.PSKEntity;
import de.frostforge.backend.rating.repository.RatingEntity;
import de.frostforge.backend.status.repository.StatusEntity;
import de.frostforge.backend.tags.repository.TagEntity;
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

    @ManyToMany
    @JoinTable(
            name = "manga_genres",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<GenreEntity> genres;

    @ManyToMany
    @JoinTable(
            name = "manga_tags",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagEntity> tags;

    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnimeEntity> adaption;

    @ManyToMany
    @JoinTable(
            name = "manga_psk",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "psk_id"))
    private List<PSKEntity> psks;

    @Column
    private LocalDate seasonStart;

    @Column
    private LocalDate seasonEnd;

    @ManyToMany
    @JoinTable(
            name = "manga_status",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id"))
    private List<StatusEntity> status;

    @ManyToMany
    @JoinTable(
            name = "manga_groups",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<GroupEntity> groups;

    @ManyToMany
    @JoinTable(
            name = "manga_companies",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<CompanyEntity> companies;

    @Column
    private String license;

    @Column
    private String description;

    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingEntity> ratings;

    @Column
    private String thumbnail;

    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CharacterEntity> characters;

    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChapterEntity> chapters;

    @Column
    private String medium;
}
