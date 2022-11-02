package de.frostforge.backend.tags.controller;

import de.frostforge.backend.tags.domain.CreateTag;
import de.frostforge.backend.tags.domain.EditTag;
import de.frostforge.backend.tags.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public TagDTO create(@Valid @RequestBody CreateTagDTO dto) {
        var test = tagService.create(new CreateTag(dto));
        //System.out.println(test.getId());
        return new TagDTO(tagService.create(new CreateTag(dto)));
    }

    @PutMapping("/{id}")
    public TagDTO update(@PathVariable Long id, @Valid @RequestBody EditTagDTO dto) {
        return new TagDTO(tagService.edit(id, new EditTag(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tagService.deleteById(id);
    }

    /**
     * Handles validation exceptions in a way that they are more human-readable
     * @param ex The exception
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
