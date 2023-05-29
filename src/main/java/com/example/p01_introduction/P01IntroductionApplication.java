package com.example.p01_introduction;

import com.example.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class P01IntroductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(P01IntroductionApplication.class, args);
    }

    @GetMapping("/register")
    public String register(Model model) {
        // Instance d'utilisateur passée à la vue
        User user = new User();

        // Envoyer cette instance à la vue
        model.addAttribute("user", user);

        return "register";
    }

}
