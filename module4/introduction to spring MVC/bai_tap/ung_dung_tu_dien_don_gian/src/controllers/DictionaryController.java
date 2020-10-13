package controllers;

import entity.Vocabulary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Translate;

@Controller
public class DictionaryController {
    @Autowired
    private Translate translate;
    @GetMapping("/")
    public String formTranslate(){
        return "translate";
    }

    @GetMapping("/translate")
    public String translateEnglish(@RequestParam String english, Model model){
        String vietNamese="";
        if (!english.equals("")) vietNamese=translate.translate(english);
        model.addAttribute("english",english);
        model.addAttribute("vietNamese",vietNamese);
        return "translate";
    }
}
