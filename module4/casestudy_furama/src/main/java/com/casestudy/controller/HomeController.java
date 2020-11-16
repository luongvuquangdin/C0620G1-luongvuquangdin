package com.casestudy.controller;

import com.casestudy.service.contract_detail_service.ContractDetailService;
import com.casestudy.service.contract_service.ContractService;
import com.casestudy.service.customer_service.CustomerService;
import com.casestudy.service.customer_using_service.CustomerUsingService;
import com.casestudy.service.employee_service.EmployeeService;
import com.casestudy.service.service_services.ServiceOfFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {
    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeServic;
    @Autowired
    ServiceOfFuramaService serviceOfFuramaService;
    @Autowired
    ContractService contractService;
    @Autowired
    ContractDetailService contractDetailService;

    @GetMapping("/")
    public String goHome(Model model){
        return "display";
    }
//    @Autowired
//    CustomerUsingService customerUsingService;
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action=request.getParameter("action");
//        if (action==null){
//            action="";
//        }
//        switch (action){
//            case "customer":
//                displayCustomer(request,response);
//                break;
//            case "employee":
//                displayEmployee(request,response);
//                break;
//            case "service":
//                displayService(request,response);
//                break;
//            case "contract":
//                displayContract(request,response);
//                break;
//            case "contractDetail":
//                displayContractDetail(request,response);
//                break;
//            default:
//                List<CustomerUsing> customerUsingList=this.customerUsingBO.findAllCustomerUsing();
//                request.setAttribute("action",action);
//                request.setAttribute("customerUsingList",customerUsingList);
//                request.getRequestDispatcher("display.html").forward(request,response);
//                break;
//
//        }
//
//    }
//
//    private void displayContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<ContractDetail> contractDetailList=this.contractDetailBO.findAllContractDetail();
//        String action=request.getParameter("action");
//        request.setAttribute("action",action);
//        request.setAttribute("contractDetailList",contractDetailList);
//        request.getRequestDispatcher("display.html").forward(request,response);
//    }
//
//    private void displayContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Contract> contractList=this.contractBO.findAllContract();
//        String action=request.getParameter("action");
//        request.setAttribute("action",action);
//        request.setAttribute("contractList",contractList);
//        request.getRequestDispatcher("display.html").forward(request,response);
//    }
//
//    private void displayService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Service> serviceList=serviceBO.findAllService();
//        String action=request.getParameter("action");
//        request.setAttribute("action",action);
//        request.setAttribute("serviceList",serviceList);
//        request.getRequestDispatcher("display.html").forward(request,response);
//    }
//
//    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Employee> employeeList=employeeBO.findAllEmployee();
//        String action=request.getParameter("action");
//        request.setAttribute("action",action);
//        request.setAttribute("employeeList",employeeList);
//        request.getRequestDispatcher("display.html").forward(request,response);
//    }
//
//    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Customer> customerList=customerBO.findAllCustomer();
//        String action=request.getParameter("action");
//        request.setAttribute("action",action);
//        request.setAttribute("customerList",customerList);
//        request.getRequestDispatcher("display.html").forward(request,response);
//    }

}
