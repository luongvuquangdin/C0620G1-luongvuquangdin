package controller;

import bo.contract_bo.ContractBO;
import bo.contract_bo.ContractBOImpl;
import bo.customer_bo.CustomerBO;
import bo.customer_bo.CustomerBOImpl;
import bo.employee_bo.EmployeeBO;
import bo.employee_bo.EmployeeBOImpl;
import bo.service_bo.ServiceBO;
import bo.service_bo.ServiceBOImpl;
import model.contract.Contract;
import model.customer.Customer;
import model.employee.Employee;
import model.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet",urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractBO contractBO=new ContractBOImpl();
    EmployeeBO employeeBO=new EmployeeBOImpl();
    CustomerBO customerBO=new CustomerBOImpl();
    ServiceBO serviceBO=new ServiceBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionContract=request.getParameter("actionContract");
        if (actionContract==null){
            actionContract="";
        }
        if (actionContract.equals("create")){
            CreateContract(request,response);
        }

    }

    private void CreateContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDate=request.getParameter("StartDate");
        String endDate=request.getParameter("EndDate");
        String deposit=request.getParameter("Deposit");
        String totalMoney=request.getParameter("TotalMoney");
        String employeeIdContract=request.getParameter("employeeIdContract");
        String customerIdContract=request.getParameter("customerIdContract");
        String serviceIdContract=request.getParameter("serviceIdContract");
        Contract contract=new Contract(startDate,endDate,deposit,totalMoney,employeeIdContract,customerIdContract,serviceIdContract);
        String message=this.contractBO.createContract(contract);

        List<Employee> employeeList=this.employeeBO.findAllEmployee();
        List<Customer> customerList=this.customerBO.findAllCustomer();
        List<Service> serviceList=this.serviceBO.findAllService();
        request.setAttribute("message",message);
        request.setAttribute("contract",contract);
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        request.getRequestDispatcher("contract/createContract.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionContract=request.getParameter("actionContract");
        if (actionContract==null){
            actionContract="";
        }
        if (actionContract.equals("create")){
            showCreateContractForm(request,response);
        }

    }

    private void showCreateContractForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList=this.employeeBO.findAllEmployee();
        List<Customer> customerList=this.customerBO.findAllCustomer();
        List<Service> serviceList=this.serviceBO.findAllService();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        request.getRequestDispatcher("contract/createContract.jsp").forward(request,response);
    }
}
