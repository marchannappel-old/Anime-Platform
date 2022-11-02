package de.frostforge.backend.tags.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateTagDTO {
    private final String name;
    private final String description;
    private final boolean isSpoiler;
}