package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Lavet af Andreas og Jonas

@Controller
public class CreateRequirementController {

    @Autowired
    RequirementRepository requirementRepository;

    //Show view only
    @GetMapping("/createrequirement")
    public String showCreateReqView(Model model){
        return "createRequirement";
    }

    //Create requirement NAME ONLY
    @PostMapping("/createrequirement")
    public String createRequirement(Model model, @RequestParam String name){
        requirementRepository.createRequirement(name);
        return "createRequirement";
    }
}
