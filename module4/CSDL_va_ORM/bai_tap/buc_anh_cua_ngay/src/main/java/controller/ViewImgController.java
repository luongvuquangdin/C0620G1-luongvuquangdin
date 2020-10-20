package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewImgController {
    @GetMapping("/")
    public String goView(){
        return "view";
    }
}
