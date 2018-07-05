package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ProductCreateRepository;
import dk.adventurealley.app.Model.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateProductController {

    @Autowired
    ProductCreateRepository proRepo = new ProductCreateRepository();

    @GetMapping("/createProduct")
    public String createProduct (Model model){
        model.addAttribute("newProduct", new Product());
        return "createProduct";
    }

    @PostMapping("/createP")
    public String productCreate (@ModelAttribute Product p) {
        proRepo.create(p);
        return "redirect:/";
    }
}
