package dev.program.linkshortener.link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LinkServiceImplTest {
    @Test
    void shouldNotCreateShortenedLinkInCaseOfOccupiedIdentifier() {
        //Given
        LinkService linkService = new LinkServiceImpl();
        LinkDto linkDto = new LinkDto("damian","test@gmail.com","google.com", LocalDate.now(), 0);
        linkService.createLink(linkDto);
        //Then
        Assertions.assertThrows(LinkAlreadyExistsException.class,
                ()->linkService.createLink(new LinkDto("damian","t@gmail.com","amazon.com", LocalDate.now(), 0)));
    }

    @Test
    void shouldReturnLinkInCaseOfNotOccupiedIdentifier() {
        //Given
        LinkService linkService = new LinkServiceImpl();
        LinkDto linkDto = new LinkDto("damian","test@gmail.com","google.com", LocalDate.now(), 0);
        //When
        LinkDto result = linkService.createLink(linkDto);
        //Then
        Assertions.assertTrue(result.getId() == linkDto.getId());
    }
}