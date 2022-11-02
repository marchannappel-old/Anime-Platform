package de.frostforge.backend.chapter.repository;

import de.frostforge.backend.manga.repository.MangaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * https://www.section.io/engineering-education/building-a-video-streaming-app-with-spring/
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Table
public class ChapterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer chapterNumber;

    @Column
    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private MangaEntity manga;
}
