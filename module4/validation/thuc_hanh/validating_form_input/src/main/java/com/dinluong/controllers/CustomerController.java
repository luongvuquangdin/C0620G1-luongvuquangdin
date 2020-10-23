package com.dinluong.controllers;

import com.dinluong.entity.Customer;
import com.dinluong.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String goView(Model model){
        model.addAttribute("listCustomer",this.customerService.findAll());
        return "view";
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customer",customer);
            return "create";
        }
        this.customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/back")
    public String back(){
        return "redirect:/";
    }
}
