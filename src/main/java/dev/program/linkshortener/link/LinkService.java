package dev.program.linkshortener.link;

public interface LinkService {
    LinkDto createLink(LinkDto toDto);

    String getLink(String id);
}
