package dev.program.linkshortener.link;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/s")
class RedirectController {

    private final LinkService service;

    RedirectController(LinkService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public void redirectLink(@PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect(service.getLink(id));
    }
}
