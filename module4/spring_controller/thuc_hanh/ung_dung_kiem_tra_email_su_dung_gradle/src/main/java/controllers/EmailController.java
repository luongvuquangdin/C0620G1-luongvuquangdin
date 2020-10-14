package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.FormatEmail;

@Controller
public class EmailController {
    @Autowired
    private FormatEmail formatEmail;

    @GetMapping("/")
    public String formEmail(){
        return "/enter_email";
    }
    @GetMapping("/check_email")
    public String checkFormatEmail(@RequestParam String email, Model model){
        String message = "" ;
        if (!email.equals("")) message=formatEmail.validateEmail(email);
        model.addAttribute("email",email);
        model.addAttribute("message",message);
        return "/enter_email";
    }
}
