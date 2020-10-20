package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customers/{id}")
    public ModelAndView infoCustomer(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("info");
        Customer customer=customerService.findOne(id);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @GetMapping("/customers")
    public String backList(){
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@RequestParam long id,@RequestParam String name,@RequestParam String address,@RequestParam String email){
        Customer customer=new Customer(id,name,address,email);
        customerService.save(customer);
        return "redirect:/";
    }

}
