package de.frostforge.backend.tags.controller;

import de.frostforge.backend.tags.domain.CreateTag;
import de.frostforge.backend.tags.domain.Tag;
import de.frostforge.backend.tags.service.TagService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

public class TagControllerTest {
    @Nested
    class ListAllTags {
        @Test
        public void callsCorrectService() {
            TagService service = Mockito.mock(TagService.class);

            new TagController(service).list();

            Mockito.verify(service, Mockito.times(1)).findAllTags();
        }

        @Test
        public void returnsAllFoundTagsAsListOfDTO() {
            TagService service = Mockito.mock(TagService.class);

            List<Tag> tags = Arrays.asList(
                    new Tag(1L, "test", "a test tag", false),
                    new Tag(2L, "test", "a test tag", false),
                    new Tag(3L, "test", "a test tag", false)
            );
            Mockito.when(service.findAllTags()).thenReturn(tags);

            List<TagDTO> tagsList = new TagController(service).list();

            assertThat(tagsList).isNotEmpty().hasSize(3);
        }
    }

    @Nested
    class ReadATagByID {
        @Test
        public void callsCorrectService() {
            TagService service = Mockito.mock(TagService.class);

            try {
                new TagController(service).read(anyLong());
            } catch (Exception e) {}

            Mockito.verify(service, Mockito.times(1)).findTagById(anyLong());
        }

        @Test
        public void optionalIsNotEmptyReturnsDTO() {
            TagService service = Mockito.mock(TagService.class);

            var optionalTag = Optional.of(new Tag(1L, "test", "test a tag", false));
            Mockito.when(service.findTagById(anyLong())).thenReturn(optionalTag);

            TagDTO dto = new TagController(service).read(1L);

            assertThat(dto)
                    .hasNoNullFieldsOrPropertiesExcept("id");
        }

        @Test
        public void optionalIsEmptyThrowsTagNotFoundException() {
            TagService service = Mockito.mock(TagService.class);

            Throwable thrown = catchThrowable(() -> {
                new TagController(service).read(2L);
            });

            assertThat(thrown)
                    .isInstanceOf(TagNotFoundException.class)
                    .hasMessageContaining("404 NOT_FOUND");
        }
    }

    @Nested
    class CreateTags {
        @Test
        public void callsCorrectService() {
            TagService service = Mockito.mock(TagService.class);


            new TagController(service).create(new CreateTagDTO("test", "test", false));


            Mockito.verify(service, Mockito.times(1)).create(new CreateTag("test", "test", false));
        }

        @Test
        public void createsNewEntryReturnsTag() {

        }
    }

    @Nested
    class EditTags {
        @Test
        public void callsCorrectService() {

        }

        @Test
        public void updatesAnExistingEntryAndReturnsUpdatedEntry() {
            
        }
    }

    @Nested
    class DeletedTags {
        @Test
        public void callsCorrectService() {
            TagService service = Mockito.mock(TagService.class);

            new TagController(service).delete(anyLong());

            Mockito.verify(service, Mockito.times(1)).deleteById(anyLong());
        }
    }
}
