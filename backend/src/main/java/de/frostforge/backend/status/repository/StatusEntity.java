package de.frostforge.backend.status.repository;

import de.frostforge.backend.anime.repository.AnimeEntity;
import de.frostforge.backend.company.repository.CompanyEntity;
import de.frostforge.backend.group.repository.GroupEntity;
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
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "status")
    private List<AnimeEntity> animes;

    @ManyToMany(mappedBy = "status")
    private List<MangaEntity> mangas;

    @ManyToMany(mappedBy = "status")
    private List<CompanyEntity> companies;

    @ManyToMany(mappedBy = "status")
    private List<GroupEntity> groups;
}
