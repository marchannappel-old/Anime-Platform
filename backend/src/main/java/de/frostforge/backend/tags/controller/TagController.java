package de.frostforge.backend.tags.controller;

import de.frostforge.backend.tags.domain.CreateTag;
import de.frostforge.backend.tags.domain.EditTag;
import de.frostforge.backend.tags.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<TagDTO> list() {
        return tagService
                .findAllTags()
                .stream()
                .map(TagDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public TagDTO read(@PathVariable Long id) {
        return tagService
                .findTagById(id)
                .map(TagDTO::new)
                .orElseThrow(TagNotFoundException::new);
    }

    @PostMapping
    public TagDTO create(@RequestBody CreateTagDTO dto) {
        // TODO: Implement validation
        return new TagDTO(tagService.create(new CreateTag(dto)));
    }

    @PutMapping("/{id}")
    public TagDTO update(@PathVariable Long id, @RequestBody EditTagDTO dto) {
        // TODO: Implement validation
        return new TagDTO(tagService.edit(id, new EditTag(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tagService.deleteById(id);
    }
}
