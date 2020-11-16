package com.casestudy.controller;

import com.casestudy.entity.customer.Customer;
import com.casestudy.service.customer_service.CustomerService;
import com.casestudy.service.customer_service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerTypeService customerTypeService;
    @Autowired
    CustomerService customerService;

    @GetMapping
    public String goDisplayListCustomer(@PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyWord,Model model){
        String keyWord1="";
        if (keyWord.isPresent()){
            keyWord1=keyWord.get();
            model.addAttribute("customerList",this.customerService.findCustomerByName(keyWord1,pageable));
        }else model.addAttribute("customerList",this.customerService.findAllCustomer(pageable));
        model.addAttribute("keyWord",keyWord1);
        return "customer/displayCustomer";
    }

    @GetMapping("/create")
    public String goCreateCustomer(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerTypeList",this.customerTypeService.findAllCustomerType());
        return "customer/createCustomer";
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute(value = "customer") Customer customer,
                                 BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customer",customer);
            model.addAttribute("customerTypeList",this.customerTypeService.findAllCustomerType());
            return "customer/createCustomer";
        }
        this.customerService.createCustomer(customer);
        return "redirect:/customers";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam String idOfCustomer){
        this.customerService.deleteCustomer(idOfCustomer);
        return "redirect:/customers";
    }

    @GetMapping("/edit")
    public String goEditCustomer(@RequestParam String idCustomer,Model model){
        model.addAttribute("customer",this.customerService.findCustomerById(idCustomer));
        model.addAttribute("customerTypeList",this.customerTypeService.findAllCustomerType());
        return "customer/edit_customer";
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute Customer customer,BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customer",customer);
            model.addAttribute("customerTypeList",this.customerTypeService.findAllCustomerType());
            return "customer/edit_customer";
        }
        this.customerService.editCustomer(customer);
        return "redirect:/customers";
    }


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String actionCustomer = request.getParameter("actionCustomer");
//        switch (actionCustomer) {
//            case "create":
//                createCustomer(request, response);
//                break;
//            case "delete":
//                deleteCustomer(request,response);
//                break;
//            case "edit":
//                editCustomer(request,response);
//                break;
//            case "find":
//                findCustomerByName(request,response);
//                break;
//            default:
//                break;
//        }
//    }
//
//    private void findCustomerByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String customerName=request.getParameter("customerName");
//        List<Customer> customerList=customerBO.findCustomerByName(customerName);
//        String action=request.getParameter("action");
//        request.setAttribute("action","customer");
//        request.setAttribute("customerList",customerList);
//        request.getRequestDispatcher("display.html").forward(request,response);
//    }
//
//    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("idCustomer");
//        String name = request.getParameter("nameCustomer");
//        String birthday = request.getParameter("birthdayCustomer");
//        String gender = request.getParameter("genderCustomer");
//        String idCard = request.getParameter("idCardCustomer");
//        String phone = request.getParameter("phoneCustomer");
//        String email = request.getParameter("emailCustomer");
//        String address = request.getParameter("addressCustomer");
//        String typeId = request.getParameter("typeIdCustomer");
//        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, typeId);
//        String message = this.customerBO.editCustomer(customer);
//        List<CustomerType> customerTypeList=customerTypeBO.findAllCustomerType();
//        request.setAttribute("customerTypeList",customerTypeList);
//        request.setAttribute("customer", customer);
//        request.setAttribute("message", message);
//        request.getRequestDispatcher("customer/edit_customer.html").forward(request, response);
//    }
//
//    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idCustomer=request.getParameter("idCustomer");
//        customerBO.deleteCustomer(idCustomer);
//        this.displayCustomer(request,response);
//
//    }
//
//    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("idCustomer");
//        String name = request.getParameter("nameCustomer");
//        String birthday = request.getParameter("birthdayCustomer");
//        String gender = request.getParameter("genderCustomer");
//        String idCard = request.getParameter("idCardCustomer");
//        String phone = request.getParameter("phoneCustomer");
//        String email = request.getParameter("emailCustomer");
//        String address = request.getParameter("addressCustomer");
//        String typeId = request.getParameter("typeIdCustomer");
//        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, typeId);
//        String message = this.customerBO.createCustomer(customer);
//        List<CustomerType> customerTypeList=customerTypeBO.findAllCustomerType();
//        request.setAttribute("customerTypeList",customerTypeList);
//        request.setAttribute("customer", customer);
//        request.setAttribute("message", message);
//        request.getRequestDispatcher("customer/createCustomer.html").forward(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String actionCustomer = request.getParameter("actionCustomer");
//        switch (actionCustomer) {
//            case "create":
//                showCreateCustomerForm(request, response);
//                break;
//            case "edit":
//                showEditCustomerForm(request, response);
//                break;
//            default:
//                break;
//        }
//
//    }
//
//    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) {
//        String idCustomer=request.getParameter("idCustomer");
//        Customer customer=customerBO.findCustomerById(idCustomer);
//        List<CustomerType> customerTypeList=customerTypeBO.findAllCustomerType();
//        request.setAttribute("customerTypeList",customerTypeList);
//        request.setAttribute("customer",customer);
//        try {
//            request.getRequestDispatcher("customer/edit_customer.html").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showCreateCustomerForm(HttpServletRequest request, HttpServletResponse response) {
//        List<CustomerType> customerTypeList=customerTypeBO.findAllCustomerType();
//        request.setAttribute("customerTypeList",customerTypeList);
//        try {
//            request.getRequestDispatcher("customer/createCustomer.html").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Customer> customerList=customerBO.findAllCustomer();
//        String action=request.getParameter("action");
//        request.setAttribute("action","customer");
//        request.setAttribute("customerList",customerList);
//        request.getRequestDispatcher("display.html").forward(request,response);
//    }
}
