package dev.program.linkshortener.link;

import dev.program.linkshortener.link.api.LinkDto;
import dev.program.linkshortener.link.api.LinkEntity;
import dev.program.linkshortener.link.api.LinkRepository;
import dev.program.linkshortener.link.api.exception.LinkAlreadyExistsException;
import dev.program.linkshortener.link.api.exception.LinkNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LinkServiceImplTest {

    @Mock
    LinkRepository repository;
    @InjectMocks
    LinkServiceImpl linkService;

    @Test
    void shouldNotCreateShortenedLinkInCaseOfOccupiedIdentifier() {
        //Given
        LinkDto linkDto = new LinkDto("damian","test@gmail.com","google.com", LocalDate.now(), 0);
        given(repository.findById("damian")).willReturn(Optional.of(LinkEntity.fromDto(linkDto)));
        //Then
        Assertions.assertThrows(LinkAlreadyExistsException.class,
                ()->linkService.createLink(new LinkDto("damian","t@gmail.com","amazon.com", LocalDate.now(), 0)));
    }

//    @Test
//    void shouldReturnLinkInCaseOfNotOccupiedIdentifier() {
//        //Given
//        LinkDto linkDto = new LinkDto("damian","test@gmail.com","google.com", LocalDate.now(), 0);
//        //When
//        LinkDto result = linkService.createLink(linkDto);
//        //Then
//        Assertions.assertTrue(result.getId() == linkDto.getId());
//    }

    @Test
    void shouldThrowLinkNotFoundExceptionInCaseOfLinkNotFound() {
        //Given
        String id = "test";
        given(repository.findById(id)).willReturn(Optional.empty());
        //Then
        Assertions.assertThrows(LinkNotFoundException.class,
                ()->linkService.getLink(id));
    }

//    @Test
//    void shouldIncrementVisitsNumberOnEntry() {
//        //Given
//        String id = "test";
//        given(repository.)
//    }

}