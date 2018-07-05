package com.example.xpdayone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    private List<User> users = new ArrayList<>();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("userlist",users);
        return "index";
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(User user, Model model){
        System.out.println("tilføjet user: ");
        user.setName(user.getName());
        users.add(user);
        model.addAttribute("userlist", users);
        return "index";
    }

}
