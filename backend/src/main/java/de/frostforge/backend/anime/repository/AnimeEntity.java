package de.frostforge.backend.anime.repository;

import de.frostforge.backend.actor.repository.ActorEntity;
import de.frostforge.backend.character.repository.CharacterEntity;
import de.frostforge.backend.company.repository.CompanyEntity;
import de.frostforge.backend.episode.repository.EpisodeEntitiy;
import de.frostforge.backend.genre.repository.GenreEntity;
import de.frostforge.backend.group.repository.GroupEntity;
import de.frostforge.backend.manga.repository.MangaEntity;
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

    @ManyToMany
    @JoinTable(
            name = "anime_genres",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<GenreEntity> genres;

    @ManyToMany
    @JoinTable(
            name = "anime_tags",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagEntity> tags;

    @ManyToMany
    @JoinTable(
            name = "anime_psks",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "psk_id"))
    private List<PSKEntity> psks;

    @Column
    private LocalDate seasonStart;

    @Column
    private LocalDate seasonEnd;

    @ManyToMany
    @JoinTable(
            name = "anime_status",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id"))
    private List<StatusEntity> status;

    @ManyToMany
    @JoinTable(
            name = "anime_groups",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<GroupEntity> groups;

    @ManyToMany
    @JoinTable(
            name = "anime_companies",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<CompanyEntity> companies;

    @Column
    private String license;

    @Column
    private String description;

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingEntity> ratings;

    @Column
    private String thumbnail;

    @Column
    private String trailer;

    @ManyToMany
    @JoinTable(
            name = "anime_actors",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<ActorEntity> actors;

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CharacterEntity> characters;

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EpisodeEntitiy> episodes;

    @Column
    private String medium;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private MangaEntity manga;
}
