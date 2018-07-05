package dk.kea.controllers;

import dk.kea.model.Interface.IOpskrifterRep;
import dk.kea.model.Interface.IUserRep;
import dk.kea.model.entities.Opskrift;
import dk.kea.model.entities.User;
import dk.kea.model.repository.OpskriftRep;
import dk.kea.model.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class PostController {

    @Autowired
    IUserRep uRep = new UserRep();

    @Autowired
    IOpskrifterRep oRep = new OpskriftRep();

    @PostMapping("/login")
    public String login(@ModelAttribute User u, Model model) throws SQLException{

            u = uRep.loginDB(u);
            if (u != null) {

                model.addAttribute("user", u);
                return "redirect:/homepage";
            }
        return "redirect:/";
    }

    @PostMapping("/signUp")
    public String createAccount(@ModelAttribute User u) throws SQLException{

        uRep.create(u);
        return "redirect:/";
    }

    @PostMapping("/createO")
    public String createO(@ModelAttribute("id") int id, Opskrift o) throws SQLException{

        oRep.create(o, id);
        return "redirect:/homepage";
    }
}
