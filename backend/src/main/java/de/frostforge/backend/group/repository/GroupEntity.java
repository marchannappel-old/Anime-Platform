package de.frostforge.backend.group.repository;

import de.frostforge.backend.anime.repository.AnimeEntity;
import de.frostforge.backend.manga.repository.MangaEntity;
import de.frostforge.backend.status.repository.StatusEntity;
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
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "group_status",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id"))
    private List<StatusEntity> status;

    @Column
    private String link;

    @Column
    private String country;

    @Column
    private String description;

    @Column
    private String logo;

    @ManyToMany(mappedBy = "groups")
    private List<AnimeEntity> animes;

    @ManyToMany(mappedBy = "groups")
    private List<MangaEntity> mangas;
}
