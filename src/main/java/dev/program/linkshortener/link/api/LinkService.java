package dev.program.linkshortener.link.api;

import dev.program.linkshortener.link.api.LinkDto;

public interface LinkService {
    LinkDto createLink(LinkDto toDto);

    String getLink(String id);

    LinkDto getLinkDto(String id);
}
