package dk.kea.controllers;

import dk.kea.model.entities.User;
import dk.kea.model.repository.CrudInterface;
import dk.kea.model.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    CrudInterface<User> uRep = new UserRepository();

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/homepage")
    public String getHomepage() {
        return "homepage";
    }

    @GetMapping("/forum")
    public String getForum() {
        return "forum";
    }

    @GetMapping("/recipes")
    public String getRecipes() {
        return "recipes";
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }
}
