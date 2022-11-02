package de.frostforge.backend.psk.repository;

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
public class PSKEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String logo;

    @Column
    private String description;

    @ManyToMany(mappedBy = "psks")
    private List<AnimeEntity> animes;

    @ManyToMany(mappedBy = "psks")
    private List<MangaEntity> mangas;
}
