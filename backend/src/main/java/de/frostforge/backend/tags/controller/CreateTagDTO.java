package de.frostforge.backend.tags.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
@Data
public class CreateTagDTO {
    @NotEmpty
    private final String name;

    @NotEmpty
    private final String description;

    @NotEmpty
    private final boolean isSpoiler;
}
