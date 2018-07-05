package designprojekt.Controllers;

import designprojekt.Entities.QA;
import designprojekt.Repositories.QARepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class QAController {

    QARepository qaRepository = new QARepository();

    @RequestMapping("/qa")
    public String QA(Model model) {
        qaRepository.create(new QA("How old is the organisation?", "10 years old", LocalDate.now()));
        qaRepository.create(new QA("For how long have you worked with pharmacovigilance?", "for 30 years", LocalDate.now()));
        qaRepository.create(new QA("What is the price for an audit?", "50000 DKR", LocalDate.now()));
        model.addAttribute("qaList", qaRepository.readAll());
        return "qa";
    }
}