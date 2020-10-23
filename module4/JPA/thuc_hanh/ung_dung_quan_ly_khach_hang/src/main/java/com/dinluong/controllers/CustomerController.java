package com.dinluong.controllers;

import com.dinluong.entity.Customer;
import com.dinluong.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public ModelAndView goViewListCustomer(){
        ModelAndView modelAndView=new ModelAndView("view");
        modelAndView.addObject("listCustomer",this.customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @GetMapping("/back")
    public  String goBack(){
        return "redirect:/";
    }

    @PostMapping("/create")
    public String createNewCustomer(@ModelAttribute Customer customer){
        this.customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        this.customerService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String goEditCustomer(@RequestParam Integer id, Model model){
        model.addAttribute("customer",this.customerService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String EditCustomer(@ModelAttribute Customer customer){
        this.customerService.update(customer);
        return "redirect:/";
    }
}
