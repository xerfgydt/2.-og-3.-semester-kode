package dk.adventurealley.app.Controllers;


import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.BookingCreateRepository;
import dk.adventurealley.app.DAO.InstructorRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import dk.adventurealley.app.Model.Entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class BookingController {

    @Autowired
    BookingCreateRepository bookRepo = new BookingCreateRepository();

    @Autowired
    ActivityRepository actiRepo = new ActivityRepository();

    @Autowired
    InstructorRepository intRepo = new InstructorRepository();


    ArrayList<Activity> activities = new ArrayList<>();
    ArrayList<Instructor> instructors = new ArrayList<>();

    //loader booking.html til at oprette en booking
    @RequestMapping(value = "/createbooking", method = RequestMethod.GET)
    public String createBooking(Model model) {
        activities = actiRepo.readAll();
        instructors = intRepo.readAll();
        model.addAttribute("booking", new Booking());
        model.addAttribute("customer", new Customer());
        model.addAttribute("instructorlist", instructors);
        model.addAttribute("activitylist", activities);
        return "booking";
    }
    //post metode til at oprette en booking
    @PostMapping("/createB")
    public String bookingCreate(@ModelAttribute Booking b, Customer c, @RequestParam String intName, @RequestParam String actiName) {
        bookRepo.create(b, c, intName, actiName);
        return "redirect:/";
    }



}