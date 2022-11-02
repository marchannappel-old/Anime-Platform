package de.frostforge.backend.company.repository;

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
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "company_status",
            joinColumns = @JoinColumn(name = "company_id"),
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

    @ManyToMany(mappedBy = "companies")
    private List<AnimeEntity> animes;

    @ManyToMany(mappedBy = "companies")
    private List<MangaEntity> mangas;
}
