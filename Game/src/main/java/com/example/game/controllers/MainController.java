package com.example.game.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home page");
        return "home";
    }

    @GetMapping("/sign_up")
    public String sign_up(Model model) {
        model.addAttribute("title", "Sign-up page");
        return "sign_up";
    }
}
