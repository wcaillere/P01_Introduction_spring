package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Préciser que cette classe est un contrôleur
@Controller
public class Main {

    // Indique une demande de type GET sur l'url "/"
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
