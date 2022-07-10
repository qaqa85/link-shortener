package dev.program.linkshortener.controller;

import dev.program.linkshortener.link.LinkDto;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

record CreateLinkDto (
        @Schema(description = "Identifier/alias to link. Used for redirection.", example = "link-alias", required = true)
        @NotBlank
        String id,
        @Email
        String email,
        @Size(min = 5, max = 60)
        String targetUrl,
        @Future
        LocalDate expirationDate,

        int visit)
{

    LinkDto toDto() {
        return new LinkDto(
                id,
                email,
                targetUrl,
                expirationDate,
                0
        );
    }
}

