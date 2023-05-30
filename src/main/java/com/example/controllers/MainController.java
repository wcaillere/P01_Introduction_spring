package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Préciser que cette classe est un contrôleur
@Controller
public class MainController {
    @GetMapping("/test")
    public String test() {
        return "index";
    }
}
