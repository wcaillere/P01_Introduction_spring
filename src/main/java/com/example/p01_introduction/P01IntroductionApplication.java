package com.example.p01_introduction;

import com.example.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

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

        List<String> professionList = Arrays.asList("Professeur", "Commercial", "Technicien");
        model.addAttribute("professionList", professionList);

        return "register";
    }

    @PostMapping("/register")
    public String RegisterPost(@ModelAttribute("user") User user) {
        System.out.println(user);
        return "register_post";
    }

}
