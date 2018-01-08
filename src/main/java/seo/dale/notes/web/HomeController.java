package seo.dale.notes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "redirect:/notes/list";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/errorTest")
    public void error() {
        throw new RuntimeException("Error Test");
    }
}
