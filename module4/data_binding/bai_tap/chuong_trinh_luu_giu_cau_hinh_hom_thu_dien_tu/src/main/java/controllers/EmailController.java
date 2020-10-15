package controllers;

import entity.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @GetMapping("/")
    public ModelAndView showInformationConfig(){
        ModelAndView modelAndView=new ModelAndView("show-config");
        modelAndView.addObject("email",new Email());
        return modelAndView;
    }
    @PostMapping("/edit")
    public String goConfigEmail(@ModelAttribute Email email, Model model){
        model.addAttribute("email",email);
        return "config-email";
    }

    @PostMapping("/config")
    public String configEmail(@ModelAttribute Email email,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute(email);
        return "redirect:/show";
    }

    @GetMapping("/show")
    public String show(){
        return "show-config";
    }


}
