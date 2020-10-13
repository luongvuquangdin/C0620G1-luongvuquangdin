package controller;

import bo.contract_bo.ContractBO;
import bo.contract_bo.ContractBOImpl;
import bo.contract_detail_bo.ContractDetailBO;
import bo.contract_detail_bo.ContractDetailBOImpl;
import bo.customer_bo.CustomerBO;
import bo.customer_bo.CustomerBOImpl;
import bo.customer_using_bo.CustomerUsingBO;
import bo.customer_using_bo.CustomerUsingBOImpl;
import bo.employee_bo.EmployeeBO;
import bo.employee_bo.EmployeeBOImpl;
import bo.service_bo.ServiceBO;
import bo.service_bo.ServiceBOImpl;
import model.contract.Contract;
import model.contract_detail.ContractDetail;
import model.customer.Customer;
import model.customer_using.CustomerUsing;
import model.employee.Employee;
import model.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"","/home"})
public class HomeServlet extends HttpServlet {
    CustomerBO customerBO=new CustomerBOImpl();
    EmployeeBO employeeBO=new EmployeeBOImpl();
    ServiceBO serviceBO=new ServiceBOImpl();
    ContractBO contractBO=new ContractBOImpl();
    ContractDetailBO contractDetailBO=new ContractDetailBOImpl();
    CustomerUsingBO customerUsingBO=new CustomerUsingBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "customer":
                displayCustomer(request,response);
                break;
            case "employee":
                displayEmployee(request,response);
                break;
            case "service":
                displayService(request,response);
                break;
            case "contract":
                displayContract(request,response);
                break;
            case "contractDetail":
                displayContractDetail(request,response);
                break;
            default:
                List<CustomerUsing> customerUsingList=this.customerUsingBO.findAllCustomerUsing();
                request.setAttribute("action",action);
                request.setAttribute("customerUsingList",customerUsingList);
                request.getRequestDispatcher("display.jsp").forward(request,response);
                break;

        }

    }

    private void displayContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ContractDetail> contractDetailList=this.contractDetailBO.findAllContractDetail();
        String action=request.getParameter("action");
        request.setAttribute("action",action);
        request.setAttribute("contractDetailList",contractDetailList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

    private void displayContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList=this.contractBO.findAllContract();
        String action=request.getParameter("action");
        request.setAttribute("action",action);
        request.setAttribute("contractList",contractList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

    private void displayService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList=serviceBO.findAllService();
        String action=request.getParameter("action");
        request.setAttribute("action",action);
        request.setAttribute("serviceList",serviceList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList=employeeBO.findAllEmployee();
        String action=request.getParameter("action");
        request.setAttribute("action",action);
        request.setAttribute("employeeList",employeeList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList=customerBO.findAllCustomer();
        String action=request.getParameter("action");
        request.setAttribute("action",action);
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

}
