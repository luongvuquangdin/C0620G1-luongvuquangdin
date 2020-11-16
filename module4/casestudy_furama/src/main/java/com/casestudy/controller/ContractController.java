package com.casestudy.controller;

import com.casestudy.entity.contract.Contract;
import com.casestudy.entity.employee.Employee;
import com.casestudy.entity.employee.User;
import com.casestudy.service.contract_service.ContractService;
import com.casestudy.service.customer_service.CustomerService;
import com.casestudy.service.employee_service.EmployeeService;
import com.casestudy.service.service_services.ServiceOfFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceOfFuramaService serviceOfFuramaService;

    @GetMapping
    public String goDisplayContractList(Model model){
        model.addAttribute("contractList",this.contractService.findAllContract());
        return "contract/contractDisplay";
    }

    @GetMapping("/create")
    public String goCreateEmployee(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("employeeList",this.employeeService.findAllEmployee());
        model.addAttribute("customerList",this.customerService.findAllCustomer());
        model.addAttribute("serviceList",this.serviceOfFuramaService.findAllService());
        return "contract/createContract";
    }

    @PostMapping("/create")
    public String goCreateEmployee(@Validated @ModelAttribute Contract contract, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("contract",contract);
            model.addAttribute("employeeList",this.employeeService.findAllEmployee());
            model.addAttribute("customerList",this.customerService.findAllCustomer());
            model.addAttribute("serviceList",this.serviceOfFuramaService.findAllService());
            return "contract/createContract";
        }
        this.contractService.createContract(contract);
        return "redirect:/contracts";
    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String actionContract=request.getParameter("actionContract");
//        if (actionContract==null){
//            actionContract="";
//        }
//        if (actionContract.equals("create")){
//            CreateContract(request,response);
//        }
//
//    }
//
//    private void CreateContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String startDate=request.getParameter("StartDate");
//        String endDate=request.getParameter("EndDate");
//        String deposit=request.getParameter("Deposit");
//        String totalMoney=request.getParameter("TotalMoney");
//        String employeeIdContract=request.getParameter("employeeIdContract");
//        String customerIdContract=request.getParameter("customerIdContract");
//        String serviceIdContract=request.getParameter("serviceIdContract");
//        Contract contract=new Contract(startDate,endDate,deposit,totalMoney,employeeIdContract,customerIdContract,serviceIdContract);
//        String message=this.contractBO.createContract(contract);
//
//        List<Employee> employeeList=this.employeeBO.findAllEmployee();
//        List<Customer> customerList=this.customerBO.findAllCustomer();
//        List<Service> serviceList=this.serviceBO.findAllService();
//        request.setAttribute("message",message);
//        request.setAttribute("contract",contract);
//        request.setAttribute("employeeList",employeeList);
//        request.setAttribute("customerList",customerList);
//        request.setAttribute("serviceList",serviceList);
//        request.getRequestDispatcher("contract/createContract.html").forward(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String actionContract=request.getParameter("actionContract");
//        if (actionContract==null){
//            actionContract="";
//        }
//        if (actionContract.equals("create")){
//            showCreateContractForm(request,response);
//        }
//
//    }
//
//    private void showCreateContractForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Employee> employeeList=this.employeeBO.findAllEmployee();
//        List<Customer> customerList=this.customerBO.findAllCustomer();
//        List<Service> serviceList=this.serviceBO.findAllService();
//        request.setAttribute("employeeList",employeeList);
//        request.setAttribute("customerList",customerList);
//        request.setAttribute("serviceList",serviceList);
//        request.getRequestDispatcher("contract/createContract.html").forward(request,response);
//    }
}
