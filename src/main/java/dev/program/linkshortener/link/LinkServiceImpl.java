package dev.program.linkshortener.link;

import dev.program.linkshortener.link.api.LinkDto;
import dev.program.linkshortener.link.api.LinkEntity;
import dev.program.linkshortener.link.api.LinkRepository;
import dev.program.linkshortener.link.api.exception.LinkAlreadyExistsException;
import dev.program.linkshortener.link.api.exception.LinkNotFoundException;
import dev.program.linkshortener.link.api.LinkService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
class LinkServiceImpl implements LinkService {

    private final LinkRepository repository;

    LinkServiceImpl(LinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkDto createLink(LinkDto toDto) {
        var result = repository.findById(toDto.getId());

        if(result.isPresent())
            throw new LinkAlreadyExistsException();

        repository.save(LinkEntity.fromDto(toDto));

        return toDto;
    }

    @Override
    @Transactional
    public String getLink(String id) {
        var result = repository.findById(id).orElseThrow(LinkNotFoundException::new);
        result.setVisits(result.getVisits() + 1);

        return result.getTargetUrl();
    }

    @Override
    public LinkDto getLinkDto(String id) {
        return repository.findById(id).orElseThrow(LinkNotFoundException::new).toDto();
    }
}
