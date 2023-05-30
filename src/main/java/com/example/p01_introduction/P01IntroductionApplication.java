package com.example.p01_introduction;

import com.example.models.Society;
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
        Society society = new Society();

        // Envoyer cette instance à la vue
        model.addAttribute("user", user);
        model.addAttribute("society", society);

        List<String> professionList = Arrays.asList("Professeur", "Commercial", "Technicien");
        model.addAttribute("professionList", professionList);

        return "register";
    }

    @PostMapping("/register")
    public String RegisterPost(@ModelAttribute("user") User user, @ModelAttribute("society") Society society) {
        System.out.println(user);
        System.out.println(society);
        return "register_post";
    }

}
