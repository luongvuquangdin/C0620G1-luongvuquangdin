package com.count.controller;

import com.count.entity.CountView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("countView")
public class CountViewController {

    public CountView setUpCounter(@ModelAttribute("countView") CountView countView) {
        return new CountView();
    }

    @GetMapping("/")
    public String get(CountView countView) {
        countView.increment();
        return "view";
    }
}
