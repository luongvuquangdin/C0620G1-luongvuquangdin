package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.CalculatorService;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    @GetMapping("/")
    public String formCalculator(){
        return "calculator";
    }

    @GetMapping("/result")
    public String calculationResult(@RequestParam String number1, @RequestParam String number2, @RequestParam String calculation, Model model){
        String result=null;
        if (number1.equals("")&!number2.equals("")){
            result = "number 1 must not be left blank";
        }else if (!number1.equals("")&number2.equals("")) result = "number 2 must not be left blank";
        else if (number1.equals("")&number2.equals("")) result = "number 1 and number 2 must not be left blank";
        else {
            double numberResult1=Double.parseDouble(number1);
            double numberResult2=Double.parseDouble(number2);
            switch (calculation) {
                case "addition":
                    result = String.valueOf(calculatorService.addition(numberResult1, numberResult2));
                    break;
                case "subtraction":
                    result = String.valueOf(calculatorService.subtraction(numberResult1, numberResult2));
                    break;
                case "multiplication":
                    result = String.valueOf(calculatorService.multiplication(numberResult1, numberResult2));
                    break;
                case "division":
                    if (numberResult2 == 0) {
                        result = "number 2 can not 0";
                    } else result = String.valueOf(calculatorService.division(numberResult1, numberResult2));
                    break;
            }
        }
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        model.addAttribute("result",result);
        return "calculator";
    }
}
