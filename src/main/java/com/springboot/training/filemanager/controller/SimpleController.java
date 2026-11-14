package com.springboot.training.filemanager.controller; // Package under the main app package so @ComponentScan can find this class

import org.springframework.beans.factory.annotation.Value; // For injecting values from application.properties
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller; // Marks this class as a Spring MVC controller bean
import org.springframework.ui.Model; // Holds data passed from controller to the view (Thymeleaf template)
import org.springframework.web.bind.annotation.RequestMapping; // Maps HTTP requests to handler methods


@EnableJpaRepositories(basePackages = "com.springboot.training.repository")
@EntityScan(basePackages = "com.springboot.training.model")
@Controller // Registers this class as a Spring bean and marks it as a web controller (returns view names, not raw JSON)
public class SimpleController {

    @Value("${spring.application.name}") // Reads spring.application.name from application.properties and injects it here
    String appName; // Field that will hold the injected application name (e.g. "filemanager")

    @RequestMapping("/") // Handles HTTP requests to the root URL path "/"
    public String homePage(Model model) { // Model is provided by Spring; use it to send data to the HTML template
        model.addAttribute("appName", appName); // Puts appName into the model so Thymeleaf can use ${appName} in home.html
        return "home"; // Returns the logical view name "home" → resolves to templates/home.html
    }
}
