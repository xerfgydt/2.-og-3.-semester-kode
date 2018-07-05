package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.ActivityRequirementsRepository;
import dk.adventurealley.app.DAO.RequirementRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {


    @Autowired
    ActivityRepository aR = new ActivityRepository();
    @Autowired
    RequirementRepository rR = new RequirementRepository();
    @Autowired
    ActivityRequirementsRepository aRR = new ActivityRequirementsRepository();
    // Globale Attributter
    ArrayList<Activity> activities = new ArrayList<>();
    String globalID;

    @GetMapping("/mainpage")
    public String mainPage(){

        return "mainPage";
    }

    @GetMapping("/")
    public String index(Model model){
        activities = aR.readAll();
        model.addAttribute("activities", activities);
        model.addAttribute("isactivitypage", true);
        return "index";
    }

    @GetMapping("/activityPage")
    public String activityPage(@RequestParam("id") String id, Model model){
        Activity temp = aR.read(activities.get(Integer.parseInt(id)).getId());
        globalID = id;
        model.addAttribute("activity", temp);
        model.addAttribute("isactivitydetailspage", true);
        return "activityPage";
    }

    @GetMapping("/deleteActivity")
    public String deleteActivity(String id){
        aR.deleteActivity(Integer.parseInt(id));
        return "redirect:/";
    }

    @GetMapping ("/editActivity")
    public String editActivity(@RequestParam("id") String id, Model model){
        model.addAttribute("newReq", new Requirement());
        model.addAttribute("requirements", rR.readAll());
        model.addAttribute("activity", aR.read(Integer.parseInt(id)));
        return "editActivity";
    }

    @PostMapping ("/editActivity")
    public String editActivity(@RequestParam("action") String action, @ModelAttribute Activity activity, @ModelAttribute Requirement newReq, Model model){
        activity.setId(activities.get(Integer.parseInt(globalID)).getId()); // sets the Activity objects ID to what the activity has in DB
        newReq.setId(rR.readReqID(newReq.getReqName()));
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
            model.addAttribute("requirements", rR.readAll());
            model.addAttribute("newReq", new Requirement());
            model.addAttribute("activity", activity);
            return "editActivity";

        }
        else if (action.equals("Gem Ændringer")){
            for (Requirement req : activity.getReqList()){
                req.setId(rR.readReqID(req.getReqName()));
            }
            aR.update(activity);
        }
        model.addAttribute("activity", activity);
        return "activityPage";
    }
}
