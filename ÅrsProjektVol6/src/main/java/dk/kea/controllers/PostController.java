package dk.kea.controllers;

import dk.kea.model.Interface.IInlægRep;
import dk.kea.model.Interface.IKommentarRep;
import dk.kea.model.Interface.IOpskrifterRep;
import dk.kea.model.Interface.IUserRep;
import dk.kea.model.entities.Indlæg;
import dk.kea.model.entities.Kommentar;
import dk.kea.model.entities.Opskrift;
import dk.kea.model.entities.User;
import dk.kea.model.repository.IndlægRep;
import dk.kea.model.repository.KommentarRep;
import dk.kea.model.repository.OpskriftRep;
import dk.kea.model.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class PostController {

    @Autowired
    IUserRep uRep = new UserRep();

    @Autowired
    IOpskrifterRep oRep = new OpskriftRep();

    @Autowired
    IInlægRep iRep = new IndlægRep();

    @Autowired
    IKommentarRep kRep = new KommentarRep();

    @PostMapping("/login")
    public String login(@ModelAttribute User u, Model model) throws SQLException{

            u = uRep.loginDB(u);
            if (u != null) {

                model.addAttribute("opskrift", new Opskrift());
                model.addAttribute("user", u);
                model.addAttribute("opskrifter", oRep.readAll(u.getId()));
                return "homepage";
            }
        return "redirect:/";
    }

    @PostMapping("/signUp")
    public String createAccount(@ModelAttribute User u) throws SQLException{

        uRep.create(u);
        return "redirect:/";
    }

    @PostMapping("/createO")
    public String createO(@RequestParam("id") int id, Opskrift o, Model model) throws SQLException{

        oRep.create(o, id);
        model.addAttribute("opskrift", new Opskrift());
        model.addAttribute("user", uRep.read(id));
        model.addAttribute("opskrifter", oRep.readAll(id));
        return "homepage";
    }

    @PostMapping("/updateO")
    public String updateO(@RequestParam("userId") int userId, @RequestParam("opskriftId") int opskriftId, Opskrift o, Model model) throws SQLException{

        oRep.update(opskriftId, o);
        model.addAttribute("opskrift", new Opskrift());
        model.addAttribute("user", uRep.read(userId));
        model.addAttribute("opskrifter", oRep.readAll(userId));
        return "homepage";
    }

    @PostMapping("/updateU")
    public String UpdateU(@RequestParam("userId") int userId, User u, Model model) throws SQLException{

        uRep.update(userId, u);
        model.addAttribute("opskrift", new Opskrift());
        model.addAttribute("user", uRep.read(userId));
        model.addAttribute("opskrifter", oRep.readAll(userId));
        return "homepage";
    }

    @PostMapping("/indlaeg")
    public String createI(@RequestParam("userId") int userId, Indlæg i, Model model) throws SQLException {


            iRep.create(i, userId);
            model.addAttribute("user", uRep.read(userId));
            model.addAttribute("forum", iRep.readAll());
            model.addAttribute("indlaeg", new Indlæg());
            model.addAttribute("kommentar", new Kommentar());
            return "forum";
        }


    @PostMapping("/kommentar")
    public String createK(@RequestParam("userId") int userId, @RequestParam("indlaegId") int indlaegId, Kommentar k, Model model) throws SQLException{

        User u = uRep.read(userId);

        kRep.create(k, u.getUsername(), indlaegId);
        model.addAttribute("user", uRep.read(userId));
        model.addAttribute("forum", iRep.readAll());
        model.addAttribute("indlaeg", new Indlæg());
        model.addAttribute("kommentar", new Kommentar());
        return "forum";
    }


}
