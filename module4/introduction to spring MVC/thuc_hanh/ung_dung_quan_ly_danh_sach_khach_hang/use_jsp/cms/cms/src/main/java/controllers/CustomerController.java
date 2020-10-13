package controllers;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/info")
    public String infomation(@RequestParam String id, Model model){
            Customer customer=customerService.findOne(Long.parseLong(id));
            model.addAttribute("customer",customer);
            return "info";
    }

    @PostMapping("/update")
    public String update(@RequestParam String id,@RequestParam String name,@RequestParam String email,@RequestParam String address,Model model){
        Customer customer=new Customer(Long.parseLong(id),name,email,address);
        customerService.save(customer);
        List<Customer> customers=customerService.findAll();
        model.addAttribute("customers",customers);
        return "list";
    }
}
