package de.frostforge.backend.tags.service;

import de.frostforge.backend.tags.domain.CreateTag;
import de.frostforge.backend.tags.domain.EditTag;
import de.frostforge.backend.tags.domain.Tag;
import de.frostforge.backend.tags.repository.TagEntity;
import de.frostforge.backend.tags.repository.TagRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

public class TagServiceTest {
    @Nested
    class FindAllTags {
        @Test
        public void callsCorrectRepository() {
            TagRepository repository = Mockito.mock(TagRepository.class);

            new TagService(repository).findAllTags();

            Mockito.verify(repository, Mockito.times(1)).findAll();
        }

        @Test
        public void findAllTagsShouldReturnAListOfTags() {
            TagRepository repository = Mockito.mock(TagRepository.class);

            List<TagEntity> tags = Arrays.asList(
                    new TagEntity(1L, "test", "a test tag", false),
                    new TagEntity(2L, "test", "a test tag", false),
                    new TagEntity(3L, "test", "a test tag", false)
            );

            Mockito.when(repository.findAll()).thenReturn(tags);

            List<Tag> tagsList = new TagService(repository).findAllTags();

            assertThat(tagsList).isNotEmpty().hasSize(3);
        }
    }

    @Nested
    class FindTagById {
        @Test
        public void callsCorrectRepository() {
            TagRepository repository = Mockito.mock(TagRepository.class);

            new TagService(repository).findTagById(anyLong());

            Mockito.verify(repository, Mockito.times(1)).findById(anyLong());
        }

        @Test
        public void findGameByIDShouldReturnGameWithRatings() {
            TagRepository repository = Mockito.mock(TagRepository.class);

            Optional<TagEntity> tagMock = Optional.of(
                    new TagEntity(1L, "test", "test", false)
            );
            Mockito.when(repository.findById(anyLong())).thenReturn(tagMock);

            Optional<Tag> game = new TagService(repository)
                    .findTagById(anyLong());

            assertThat(game)
                    .isPresent()
                    .isNotEmpty();
        }
    }

    @Nested
    class CreateTags {
        @Test
        public void callsCorrectRepository() {
            TagRepository repository = Mockito.mock(TagRepository.class);

            // TODO: Mock this

            new TagService(repository).create(new CreateTag("test", "test", false));

            Mockito.verify(repository, Mockito.times(1)).save(new TagEntity(1L, "test", "test", false));
        }

        @Test
        public void createShouldCreateANewEntryAndReturnThatEntry() {
            // TODO: Implement
        }
    }

    @Nested
    class EditTags {
        @Test
        public void callsCorrectRepository() {
            TagRepository repository = Mockito.mock(TagRepository.class);

            // TODO: Mock this

            new TagService(repository).edit(anyLong(), new EditTag("test", "test", false));

            Mockito.verify(repository, Mockito.times(1)).save(new TagEntity());
        }

        @Test
        public void editShouldUpdateAnEntryAndReturnThatEntry() {
            // TODO: Implement
        }
    }

    @Nested
    class DeleteTagByID {
        @Test
        public void callsCorrectRepository() {
            TagRepository repository = Mockito.mock(TagRepository.class);

            new TagService(repository).deleteById(anyLong());

            Mockito.verify(repository, Mockito.times(1)).deleteById(anyLong());
        }

        @Test
        public void deleteByIdShouldDeleteAnEntry() {
            // TODO: Implement
        }
    }
}
