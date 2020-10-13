package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Convert;

@Controller
public class ConvertMoneyController {
    @Autowired
    private Convert convert;
    @GetMapping("/")
    public String formConvert(){
        return "form_convert";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam String vietNam, @RequestParam String usd,Model model){
        double result=0;
        String resultFinal=null;
        if (vietNam.equals("")){
            result=convert.ConvertVietNam(Double.parseDouble(usd));
            resultFinal=String.valueOf(result)+" Viet Nam dong";
        }else {
            result=convert.ConvertUSD(Double.parseDouble(vietNam));
            resultFinal=String.valueOf(result)+" USD";
        }

        model.addAttribute("resultFinal",resultFinal);
        model.addAttribute("vietNam",vietNam);
        model.addAttribute("usd",usd);

        return "form_convert";

    }

}
