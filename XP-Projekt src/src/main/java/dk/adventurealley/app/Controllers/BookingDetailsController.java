package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.BookingRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class BookingDetailsController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/bookingdetails")
    public String showBookingDetails(@RequestParam int id, Model model){
        Booking booking = bookingRepository.read(id);
        model.addAttribute("booking", booking);
        model.addAttribute("isbookingdetailspage", true);
        model.addAttribute("customer", booking.getCustomer());
        model.addAttribute("activity", booking.getActivity());
        return "bookingDetails";
    }
}
