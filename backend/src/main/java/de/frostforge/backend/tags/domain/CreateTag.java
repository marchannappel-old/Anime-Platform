package de.frostforge.backend.tags.domain;

import de.frostforge.backend.tags.controller.CreateTagDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTag {
    private final String name;
    private final String description;
    private final boolean isSpoiler;

    public CreateTag(CreateTagDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.isSpoiler = dto.isSpoiler();
    }
}
