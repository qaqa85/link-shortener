package dev.program.linkshortener.link;

import dev.program.linkshortener.link.exception.LinkAlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
class LinkServiceImpl implements LinkService {

    private final HashMap<String, LinkDto> repository;

    LinkServiceImpl() {
        this.repository = new HashMap<>();
    }

    @Override
    public LinkDto createLink(LinkDto toDto) {
        if (repository.containsKey(toDto.getId())) {
            throw new LinkAlreadyExistsException();
        }
        repository.put(toDto.id, toDto);

        return repository.get(toDto.id);
    }

    @Override
    public String getLink(String id) {
        return repository.get(id).targetUrl;
    }
}
