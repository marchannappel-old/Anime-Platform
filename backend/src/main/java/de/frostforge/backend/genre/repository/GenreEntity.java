package de.frostforge.backend.genre.repository;

import de.frostforge.backend.anime.repository.AnimeEntity;
import de.frostforge.backend.manga.repository.MangaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "genres")
    private List<AnimeEntity> animes;

    @ManyToMany(mappedBy = "genres")
    private List<MangaEntity> mangas;
}
