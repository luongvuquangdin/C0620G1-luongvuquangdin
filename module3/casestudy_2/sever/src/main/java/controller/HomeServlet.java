package controller;

import bo.bocustomer.CustomerBO;
import bo.bocustomer.CustomerBOImpl;
import bo.boemployee.EmployeeBO;
import bo.boemployee.EmployeeBOImpl;
import bo.boservice.ServiceBO;
import bo.boservice.ServiceBOImpl;
import model.modelcustomer.Customer;
import model.modelemployee.Employee;
import model.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"","/home"})
public class HomeServlet extends HttpServlet {
    CustomerBO customerBO=new CustomerBOImpl();
    EmployeeBO employeeBO=new EmployeeBOImpl();
    ServiceBO serviceBO=new ServiceBOImpl();
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
            case "contact":
                break;
            default:
                response.sendRedirect("display.jsp");
                break;

        }

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
