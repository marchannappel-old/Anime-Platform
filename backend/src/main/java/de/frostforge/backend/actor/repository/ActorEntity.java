package de.frostforge.backend.actor.repository;

import de.frostforge.backend.anime.repository.AnimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String bloodGroup;

    @Column
    private Date birthday;

    @Column
    private String birthplace;

    @Column
    private String livingPlace;

    @Column
    private String nationality;

    @Column
    @ElementCollection
    private Map<String, String> websites;

    @Column
    private String tldr;

    @Column
    private String biography;

    @Column
    private String avatar;

    @ManyToMany(mappedBy = "actors")
    private List<AnimeEntity> animes;
}
