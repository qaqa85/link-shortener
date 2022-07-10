package dev.program.linkshortener.link;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class LinkDto {
    String id;
    String email;
    String targetUrl;
    LocalDate expirationDate;
    int visits;

    public LinkDto(String id, String email, String targetUrl, LocalDate expirationDate, int visits) {
        this.id = id;
        this.email = email;
        this.targetUrl = targetUrl;
        this.expirationDate = expirationDate;
        this.visits = visits;
    }

    public String getShortenedLink() {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/s/{id}")
                .buildAndExpand(id)
                .toUriString();
    }

    String getId() {
        return id;
    }
}
