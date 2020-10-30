package com.jqueryvsajax.controllers;

import com.jqueryvsajax.entity.Smartphone;
import com.jqueryvsajax.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showIndex(){
        return "index";
    }
}
