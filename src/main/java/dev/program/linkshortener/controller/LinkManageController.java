package dev.program.linkshortener.controller;

import dev.program.linkshortener.link.api.LinkDto;
import dev.program.linkshortener.link.api.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/links")
class LinkManageController {

    private final LinkService service;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@Valid @RequestBody CreateLinkDto link) {
        return service.createLink(link.toDto());
    }



}
