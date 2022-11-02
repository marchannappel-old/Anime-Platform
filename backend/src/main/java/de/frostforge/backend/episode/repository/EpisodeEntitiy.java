package de.frostforge.backend.episode.repository;

import de.frostforge.backend.anime.repository.AnimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Table
public class EpisodeEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer episodeNumber;

    @Column
    private String language;

    @Column
    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private AnimeEntity anime;
}
