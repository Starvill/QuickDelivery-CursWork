package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/account")
    public String showAccountPage(HttpServletRequest request, Model model) {
        model.addAttribute("username", request.getUserPrincipal().getName());
        model.addAttribute("linkOutOrUp", "/logout");
        model.addAttribute("textOutOrUp", "Выйти");
        model.addAttribute("linkInOrAccount", "/account");
        model.addAttribute("textInOrAccount", "Аккаунт");
        model.addAttribute("welcome", "Вы вошли как " + request.getUserPrincipal().getName() + "!");

        User user  = userRepository.findByUsername(request.getUserPrincipal().getName());
        model.addAttribute("user", user);
        model.addAttribute("orders", user.getOrders());
        return "account";
    }
}
