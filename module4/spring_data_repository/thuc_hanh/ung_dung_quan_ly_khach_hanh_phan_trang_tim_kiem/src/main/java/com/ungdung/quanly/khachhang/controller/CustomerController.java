package com.ungdung.quanly.khachhang.controller;

import com.ungdung.quanly.khachhang.entity.Customer;
import com.ungdung.quanly.khachhang.service.CustomerService;
import com.ungdung.quanly.khachhang.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ProvinceService provinceService;

    @GetMapping("/")
    public String goView(Model model, @PageableDefault(size = 5) Pageable pageable,@RequestParam Optional<String> keyWord){
        String keyWord1="";
        if (!keyWord.isPresent()) {
            model.addAttribute("listCustomer", this.customerService.findAll(pageable));
        }else {
            keyWord1=keyWord.get();
            model.addAttribute("listCustomer",this.customerService.findAllByNameContaining(pageable,keyWord1));
        }

        model.addAttribute("keyWord",keyWord1);
        return "custormer/view";
    }
    @GetMapping("back")
    public String back(){
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView goDelete(@PathVariable Integer id){
        ModelAndView modelAndView=new ModelAndView("custormer/delete");
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
        return "custormer/create";
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
        return "custormer/edit";
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer){
        this.customerService.edit(customer);
        return "redirect:/";
    }
}
