package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.RequirementRepository;
import dk.adventurealley.app.DAO.ActivityRequirementsRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CreateActivityController {
    @Autowired
    ActivityRepository aR = new ActivityRepository();
    @Autowired
    RequirementRepository rR = new RequirementRepository();
    @Autowired
    ActivityRequirementsRepository aRR = new ActivityRequirementsRepository();

    ArrayList<Requirement> requirements  = new ArrayList<>();

    @RequestMapping(value = "/createactivity", method = RequestMethod.GET)
    public String createActivity(Model model) {
        requirements = rR.readAll();
        Activity a = new Activity();
        model.addAttribute("activity", a);
        model.addAttribute("req", requirements);
        model.addAttribute("newReq",new Requirement());
        return "createActivity";
    }
    @PostMapping ("/createactivity")
    public String editActivity(@RequestParam("action") String action, @ModelAttribute Activity activity, @ModelAttribute Requirement newReq, Model model){
        ArrayList<String> reqNames = new ArrayList<>();
        if(activity.getReqList() != null) {
            for (Requirement requirement : activity.getReqList()) {
                reqNames.add(requirement.getReqName());
            }
        }
        if (!newReq.getReqName().equals(null) && !reqNames.contains(newReq.getReqName()) && action.equals("Tilføj krav")) {
            if(activity.getReqList() == null){
                activity.setReqList(new ArrayList<Requirement>());
                activity.getReqList().add(newReq);
            }
            else {
                activity.getReqList().add(newReq);
            }
            model.addAttribute("req", requirements);
            model.addAttribute("newReq", new Requirement());
            model.addAttribute("activity", activity);
            return "createActivity";

        }
        else if (action.equals("Opret Aktivitet")){
            for (Requirement req : activity.getReqList()){
                req.setId(rR.readReqID(req.getReqName()));
            }
            aR.create(activity);
        }
        model.addAttribute("activity", activity);
        return "activityPage";
    }
    /*
    @PostMapping("/addReq")
    public String addRequirement(@ModelAttribute Activity a, Model model, @RequestParam String name, @RequestParam String value) {
        Requirement r = new Requirement(name, value);
        activeReqs.add(r);
        model.addAttribute("activity", a);
        model.addAttribute("req", requirements);
        return "createActivity";
    }

    @PostMapping("/createA")
    public String activityCreate(@ModelAttribute Activity a) {
        a.setReqList(activeReqs);
        activityRepo.create(a);
        activeReqs.clear();
        return "redirect:/";
    }*/
}
