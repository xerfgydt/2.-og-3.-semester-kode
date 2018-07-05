package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.DailyIncomeRepository;
import dk.adventurealley.app.Model.Entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@Controller
public class DailyIncomeController {

    @Autowired
    private DailyIncomeRepository dIR;
    @GetMapping("/dailyincome")
    public String dailyIncome(Model model){


        model.addAttribute("dailyIncomeArray", dIR.readAll());
        return "viewTotalDailyIncome";
    }



}


