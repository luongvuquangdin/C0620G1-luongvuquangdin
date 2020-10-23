package com.registration.registration.controllers;

import com.registration.registration.entity.User;
import com.registration.registration.service.FormRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    FormRegistrationService registrationService;

    @GetMapping("/")
    public String goView(Model model,Pageable pageable){
        model.addAttribute("listUser",this.registrationService.findAll(pageable));
        return "view";
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("user",new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute User user, BindingResult bindingResult, Model model){
        new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("user",user);
            return "create";
        }
        this.registrationService.save(user);
        return "redirect:/";
    }

    @GetMapping("/back")
    public String back(){
        return "redirect:/";
    }

}
