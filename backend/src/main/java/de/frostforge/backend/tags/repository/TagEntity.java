package de.frostforge.backend.tags.repository;

import de.frostforge.backend.anime.repository.AnimeEntity;
import de.frostforge.backend.manga.repository.MangaEntity;
import de.frostforge.backend.tags.domain.CreateTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean isSpoiler;

    @ManyToMany(mappedBy = "tags")
    private List<AnimeEntity> animes;

    @ManyToMany(mappedBy = "tags")
    private List<MangaEntity> mangas;

    public TagEntity(CreateTag entity) {
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.isSpoiler = entity.isSpoiler();
    }
}
