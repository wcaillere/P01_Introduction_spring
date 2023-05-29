package com.example.config;

/*
Classe qui configure, parmi d'autres choses, les résolveurs (c.a.d les traitements qui interviennent
pour transformer les models en views concrètes, réelles, prêtes à être envoyées à l'utilisateur
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

// Décoration pour définir cette classe comme une classe de configuration
@Configuration
// Préciser que je veux activer le module WebMVC de Spring
@EnableWebMvc
// Demander à Spring de parcourir/fouiller/scanner tous les packages com.example pour trouver les classes à partir desquelles
// il doit obtenir des instances (des beans) à stocker dans son conteneur et toutes les méthodes des classes qui retournent
// des beans à stocker aussi dans ce conteneur
@ComponentScan(basePackages = "com.example")
public class ConfigurationSpringMVC implements WebMvcConfigurer {

    // Indique où se trouve les templates (les cadres) des vues, en créant un resolver, le configurer et le retourner
    @Bean
    public SpringResourceTemplateResolver TemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

        // Préciser l'endroit où se trouve les templates (les cadres) des vues
        resolver.setPrefix("classpath:/templates/");
        // Préciser la nature des fichiers
        resolver.setSuffix(".html");
        // Ne pas permettre l'utilisation des caches server
        resolver.setCacheable(false);

        return resolver;
    }

    // créer et configurer le moteur de traitement des vues
    public SpringTemplateEngine TemplateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();

        // Passer au moteur de traitement des vues le resolver pour qu'il sache où trouver ces vues
        engine.setTemplateResolver(TemplateResolver());

        // Autoriser l'utilisation de EL (Expression Language)
        engine.setEnableSpringELCompiler(true);

        return engine;
    }

    // Configurer l'environnement Thymeleaf
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver tvr = new ThymeleafViewResolver();

        // lui donner le moteur de traitement de template
        tvr.setTemplateEngine(TemplateEngine());

        registry.viewResolver(tvr);
    }

    // créer et enregistrer les endroits où se trouvent les ressources statiques
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js");
        // classpath: déclarer où se trouve le répertoire js
    }
}
