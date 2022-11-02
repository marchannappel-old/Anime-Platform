package de.frostforge.backend.tags.domain;

import de.frostforge.backend.tags.controller.EditTagDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditTag {
    private final String name;
    private final String description;
    private final boolean isSpoiler;

    public EditTag(EditTagDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.isSpoiler = dto.isSpoiler();
    }
}
