package dev.program.linkshortener.link;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class WebController {

    @RequestMapping("/")
    String webPage() {
        return "index.html";
    }
}
