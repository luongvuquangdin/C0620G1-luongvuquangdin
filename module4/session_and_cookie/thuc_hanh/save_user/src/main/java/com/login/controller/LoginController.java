package com.login.controller;

import com.login.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @GetMapping("/")
    public String goLogin(@CookieValue(value = "nameUser",defaultValue = "") String setUserName,@CookieValue(value = "passUserC",defaultValue = "") String setPassName, Model model){
        model.addAttribute("user",new User(setUserName,setPassName));
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user , HttpServletResponse response){
        Cookie nameUserC=new Cookie("nameUser",user.getName());
        Cookie passUserC=new Cookie("passUserC",user.getPassword());
        nameUserC.setMaxAge(60*60*24);
        passUserC.setMaxAge(60*60*24);
        response.addCookie(nameUserC);
        response.addCookie(passUserC);
        return "welcome";
    }

    @PostMapping("/logout")
    public String logOut(){
        return "redirect:/";
    }
}
