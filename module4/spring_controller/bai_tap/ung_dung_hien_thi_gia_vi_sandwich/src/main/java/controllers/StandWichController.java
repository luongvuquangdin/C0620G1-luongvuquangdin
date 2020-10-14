package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StandWichController {
    @GetMapping("/")
    public String formSpice(){
        return "choose_spice_with_sandwich";
    }

    @GetMapping("/spice")
    public String save(@RequestParam String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "display_spice";
    }
}
