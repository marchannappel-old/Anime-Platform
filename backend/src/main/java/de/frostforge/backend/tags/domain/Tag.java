package de.frostforge.backend.tags.domain;

import de.frostforge.backend.tags.repository.TagEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tag {
    private final Long id;
    private final String name;
    private final String description;
    private final boolean isSpoiler;

    public Tag(TagEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.isSpoiler = entity.isSpoiler();
    }

    public Tag(CreateTag)
}
