package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.BookingRepository;
import dk.adventurealley.app.DAO.InstructorRepository;
import dk.adventurealley.app.Model.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

@Controller
public class EditBookingController {

    @Autowired
    private BookingRepository bR;
    @Autowired
    private ActivityRepository aR;
    @Autowired
    private InstructorRepository iR;
    RedirectAttributes redirectAttributes;


    @GetMapping("/editBooking")
    public String editBooking(@RequestParam("id") int id, Model model){

        model.addAttribute("booking", bR.read(id));
        model.addAttribute("activities", aR.readAll());
        model.addAttribute("instructors", iR.readAll());
        System.out.println(bR.read(1));
        return "editBooking";
    }

    @PostMapping("/editBooking")
    public String editBooking(@RequestParam("id") int id, @ModelAttribute Instructor newInstructor, @ModelAttribute Activity newActivity, @ModelAttribute Booking booking, Model model){
        booking.setInstructor(iR.readOutFromName(booking.getInstructor().getName()));
        booking.getActivity().setId(aR.readActivityID(booking.getActivity().getName()));
        bR.update(booking);
        return "redirect:/bookingdetails?id=" + booking.getId();
    }
}
