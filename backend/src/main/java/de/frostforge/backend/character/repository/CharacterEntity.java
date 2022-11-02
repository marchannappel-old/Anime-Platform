package de.frostforge.backend.character.repository;

import de.frostforge.backend.anime.repository.AnimeEntity;
import de.frostforge.backend.manga.repository.MangaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String otherNames;

    @Column
    private String tags;

    @Column
    private String gender;

    @Column
    private String bloodGroup;

    @Column
    private String height;

    @Column
    private String weight;

    @Column
    private Date birthday;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private AnimeEntity anime;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private MangaEntity manga;
}
