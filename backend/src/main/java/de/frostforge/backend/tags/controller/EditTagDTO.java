package de.frostforge.backend.tags.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
public class EditTagDTO {
    @NotEmpty
    private final String name;

    @NotEmpty
    private final String description;

    @NotEmpty
    private final boolean isSpoiler;
}
