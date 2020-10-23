package com.khachhang.diachi.controller;

import com.khachhang.diachi.entity.Customer;
import com.khachhang.diachi.service.CustomerService;
import com.khachhang.diachi.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ProvinceService provinceService;

    @GetMapping("/")
    public String goView(Model model){
        model.addAttribute("listCustomer",this.customerService.findAll());
        return "view";
    }
    @GetMapping("back")
    public String back(){
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView goDelete(@PathVariable Integer id){
        ModelAndView modelAndView=new ModelAndView("delete");
        modelAndView.addObject("customer",this.customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id){
        this.customerService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String goCreat(Model model){
        model.addAttribute("listProvince",this.provinceService.findAll());
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String creatCustomer(@ModelAttribute Customer customer){
        this.customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String goEdit(@PathVariable Integer id,Model model){
        model.addAttribute("customer",this.customerService.findById(id));
        model.addAttribute("listProvince",this.provinceService.findAll());
        return "edit";
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer){
        this.customerService.edit(customer);
        return "redirect:/";
    }
}
