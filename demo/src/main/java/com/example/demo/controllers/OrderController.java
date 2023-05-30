package com.example.demo.controllers;


import com.example.demo.repositories.UserRepository;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.repositories.OrderRepository;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/orders")
    public String getAnimalInfo(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @GetMapping("/orders/add")
    public String addOrder(Model model) {
        return "addorder";
    }

    @PostMapping("/order/add")
    public String postAddOrder(@RequestParam String name,
                               @RequestParam String date,
                               @RequestParam String addressFrom,
                               @RequestParam String addressTo,
                               @RequestParam String type,
                               @RequestParam String orderPhoneNumber, Model model, HttpServletRequest request){
        Order order = new Order(name, date, addressFrom, addressTo, orderPhoneNumber, type);
        order.setUser(userRepository.findByUsername(request.getUserPrincipal().getName()));
        model.addAttribute("success-user", order);
        orderRepository.save(order);
        return "redirect:/account";
    }
}
