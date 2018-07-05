package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ProductRepository;
import dk.adventurealley.app.Model.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ViewProductController {

    @Autowired
    ProductRepository pr = new ProductRepository();

    ArrayList<Product> productList = new ArrayList<>();

    @GetMapping("/viewProducts")
    public String viewProducts(Model model){
        //System.out.println("productList size: "+pr.readAll().size());
        productList = pr.readAll();
        model.addAttribute("productList", productList);
        model.addAttribute("isProductsPage", true);
        return "viewProducts";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Integer id){
        pr.deleteProduct(id);
        return "redirect:/viewProducts";
    }

}