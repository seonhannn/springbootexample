package com.example.springbootexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    String niceToMeetYou(Model model) {
        model.addAttribute("username", "한지선");
        return "greetings";
    }

    @GetMapping("/bye")
    String seeYouNext(Model model) {
        model.addAttribute("username", "한지선");
        return "goodbye";
    }
}
