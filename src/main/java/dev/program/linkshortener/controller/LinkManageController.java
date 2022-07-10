package dev.program.linkshortener.controller;

import dev.program.linkshortener.controller.CreateLinkDto;
import dev.program.linkshortener.link.LinkDto;
import dev.program.linkshortener.link.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/links")
class LinkManageController {

    private final LinkService service;

    LinkManageController(LinkService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@Valid @RequestBody CreateLinkDto link) {
        return service.createLink(link.toDto());
    }



}
