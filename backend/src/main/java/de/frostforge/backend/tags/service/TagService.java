package de.frostforge.backend.tags.service;

import de.frostforge.backend.tags.domain.CreateTag;
import de.frostforge.backend.tags.domain.EditTag;
import de.frostforge.backend.tags.domain.Tag;
import de.frostforge.backend.tags.repository.TagEntity;
import de.frostforge.backend.tags.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> findAllTags() {
        return tagRepository
                .findAll()
                .stream()
                .map(Tag::new)
                .toList();
    }

    public Optional<Tag> findTagById(Long id) {
        return tagRepository
                .findById(id)
                .map(Tag::new);
    }

    public Tag create(CreateTag tag) {
        return new Tag(tagRepository.save(new TagEntity(tag)));
    }

    public Tag edit(Long id, EditTag tag) {
        Optional<TagEntity> oldTag = tagRepository.findById(id);

        if (oldTag.isPresent()) {
            TagEntity newTag = oldTag.get();
            newTag.setName(tag.getName());
            newTag.setDescription(tag.getDescription());
            newTag.setSpoiler(tag.isSpoiler());
            return new Tag(tagRepository.save(newTag));
        }
        return null;
    }

    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }
}
