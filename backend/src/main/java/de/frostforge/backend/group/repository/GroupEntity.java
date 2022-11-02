package de.frostforge.backend.group.repository;

import de.frostforge.backend.status.repository.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column
    private StatusEntity status;

    @Column
    private String link;

    @Column
    private String country;

    @Column
    private String description;

    @Column
    private String logo;
}
