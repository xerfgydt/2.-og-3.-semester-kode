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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class HomeController {

    @Autowired
    IInlægRep iRep = new IndlægRep();

    @Autowired
    IOpskrifterRep oRep = new OpskriftRep();

    @Autowired
    IUserRep uRep = new UserRep();

    @Autowired
    IKommentarRep kRep = new KommentarRep();

    @GetMapping("/")
    public String index(Model model){

       model.addAttribute("opskrifter", oRep.readAll(1));
        return "index";
    }

    @GetMapping("/homepage")
    public String getHomepage(@RequestParam("userId") int id, Model model){

        model.addAttribute("opskrift", new Opskrift());
        model.addAttribute("user", uRep.read(id));
        model.addAttribute("opskrifter", oRep.readAll(id));

        return "homepage";
    }

    @GetMapping("/signUp")
    public String signup(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("opskrifter", oRep.readAll(1));
        return "signUp";
    }

    @GetMapping("/deleteO")
    public String deleteO(@RequestParam("opskriftId") int opskriftId, @RequestParam("userId") int userId, Model model){
        oRep.delete(opskriftId);
        model.addAttribute("opskrift", new Opskrift());
        model.addAttribute("user", uRep.read(userId));
        model.addAttribute("opskrifter", oRep.readAll(userId));
        return "homepage";
    }

    @GetMapping("/updateO")
    public String getUpdateO(@RequestParam("opskriftId") int opskriftId, @RequestParam("userId") int userId, Model model){

        model.addAttribute("user", uRep.read(userId));
        model.addAttribute("opskrift", oRep.read(opskriftId));
        return "updateOpskrift";
    }

    @GetMapping("/updateU")
    public String getUpdateU(@RequestParam("userId") int userId, Model model){

        model.addAttribute("user", uRep.read(userId));
        return "updateUser";
    }

    @GetMapping("/deleteU")
    public String deleteU(@RequestParam("userId") int userId){

        uRep.delete(userId);
        return "index";
    }

    @GetMapping("/forum")
    public String getForum(@RequestParam("userId") int userId, Model model) throws SQLException{



            model.addAttribute("user", uRep.read(userId));
            model.addAttribute("forum", iRep.readAll());
            model.addAttribute("indlaeg", new Indlæg());
            model.addAttribute("kommentar", new Kommentar());
            return "forum";
        }


    @GetMapping("/logout")
    public String logout(){
        return "redirect:/";
    }

    @GetMapping("/deleteI")
    public String deleteI(@RequestParam("inlaegId") int indlægId, @RequestParam("userId") int userId, Model model){

        iRep.delete(indlægId);
        model.addAttribute("user", uRep.read(userId));
        model.addAttribute("forum", iRep.readAll());
        model.addAttribute("indlaeg", new Indlæg());
        model.addAttribute("kommentar", new Kommentar());
        return "forum";
    }

    @GetMapping("/deleteK")
    public String deleteK(@RequestParam("kommentarId") int kommentarId, @RequestParam("userId") int userId, Model model){

        kRep.delete(kommentarId);
        model.addAttribute("user", uRep.read(userId));
        model.addAttribute("forum", iRep.readAll());
        model.addAttribute("indlaeg", new Indlæg());
        model.addAttribute("kommentar", new Kommentar());
        return "forum";
    }


}
