package dk.kea.controllers;

import dk.kea.model.Interface.IInlægRep;
import dk.kea.model.Interface.IOpskrifterRep;
import dk.kea.model.Interface.IUserRep;
import dk.kea.model.entities.Opskrift;
import dk.kea.model.entities.User;
import dk.kea.model.repository.IndlægRep;
import dk.kea.model.repository.OpskriftRep;
import dk.kea.model.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @Autowired
    IInlægRep iRep = new IndlægRep();

    @Autowired
    IOpskrifterRep oRep = new OpskriftRep();

    @Autowired
    IUserRep uRep = new UserRep();

    @GetMapping("/")
    public String index(Model model){

       model.addAttribute("user", new User());
       model.addAttribute("opskrifter", oRep.readAll(1));
        return "index";
    }

    @GetMapping("/homepage")
    public String index(@ModelAttribute User u, Model model){

        model.addAttribute("opskrift", new Opskrift());
        model.addAttribute("user", uRep.read(u.getId()));
        model.addAttribute("opskrifter", oRep.readAll(u.getId()));
        return "homepage";
    }

    @GetMapping("/signUp")
    public String signup(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("opskrifter", oRep.readAll(1));
        return "signUp";
    }
}
