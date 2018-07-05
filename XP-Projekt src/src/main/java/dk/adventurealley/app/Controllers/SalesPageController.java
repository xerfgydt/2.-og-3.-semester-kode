package dk.adventurealley.app.Controllers;


import dk.adventurealley.app.DAO.*;
import dk.adventurealley.app.Model.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class SalesPageController {
    private SalesCart salesCart = new SalesCart();

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public SaleRepository saleRepository;

    @RequestMapping(value = "/salesPage", method = RequestMethod.GET)
    public String showSalesPage(Model model) {
        model.addAttribute("salesCartList", salesCart.getList());
        model.addAttribute("totalPrice", salesCart.calculateTotal());
        model.addAttribute("productList", productRepository.readAll());
        model.addAttribute("productSeed", new Product());


        return "salesPage";
    }

    @PostMapping("/addProduct")
    public String addProductToCart(@RequestParam int id, Model model){

        salesCart.addProductToCart(productRepository.read(id));
        return "redirect:/salesPage";
    }

    @PostMapping("/removeProduct")
    public String removeProductFromCart(@RequestParam int id, Model model){
        salesCart.removeProduct(id);
        return "redirect:/salesPage";
    }

    @PostMapping("/checkout")
    public String completeSale(){
        saleRepository.create(salesCart.makeSale());
        salesCart = new SalesCart();
        return "redirect:/salesPage";
    }
}