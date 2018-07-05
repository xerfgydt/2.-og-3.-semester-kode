package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ProductCreateRepository;
import dk.adventurealley.app.DAO.ProductRepository;
import dk.adventurealley.app.Model.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class EditProductController {

    @Autowired
    ProductCreateRepository proRepo = new ProductCreateRepository();

    @Autowired
    ProductRepository pr = new ProductRepository();

    ArrayList<Product> productList = new ArrayList<>();

    @GetMapping("/editProduct")
    public String editProduct (@RequestParam("id") int id, Model model) {
        model.addAttribute("product", proRepo.readSpecific(id));
        return "editProduct";
    }

    @PostMapping("productEdit")
    public String productEdit (@ModelAttribute Product p, Model model) {
        proRepo.updateProduct(p);
        productList = pr.readAll();
        model.addAttribute("productList", productList);
        model.addAttribute("isProductsPage", true);
        return "viewProducts";
    }
}
