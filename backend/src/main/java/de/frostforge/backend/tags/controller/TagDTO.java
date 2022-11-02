package de.frostforge.backend.tags.controller;

import de.frostforge.backend.tags.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TagDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final boolean isSpoiler;

    public TagDTO(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
        this.description = tag.getDescription();
        this.isSpoiler = tag.isSpoiler();
    }
}
