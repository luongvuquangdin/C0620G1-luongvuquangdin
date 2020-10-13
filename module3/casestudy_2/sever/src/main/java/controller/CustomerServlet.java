package controller;

import bo.customer_bo.CustomerBO;
import bo.customer_bo.CustomerBOImpl;
import bo.customer_bo.CustomerTypeBO;
import bo.customer_bo.CustomerTypeBOimpl;
import model.customer.Customer;
import model.customer.CustomerType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerTypeBO customerTypeBO=new CustomerTypeBOimpl();
    CustomerBO customerBO = new CustomerBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionCustomer = request.getParameter("actionCustomer");
        switch (actionCustomer) {
            case "create":
                createCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "find":
                findCustomerByName(request,response);
                break;
            default:
                break;
        }
    }

    private void findCustomerByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName=request.getParameter("customerName");
        List<Customer> customerList=customerBO.findCustomerByName(customerName);
        String action=request.getParameter("action");
        request.setAttribute("action","customer");
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idCustomer");
        String name = request.getParameter("nameCustomer");
        String birthday = request.getParameter("birthdayCustomer");
        String gender = request.getParameter("genderCustomer");
        String idCard = request.getParameter("idCardCustomer");
        String phone = request.getParameter("phoneCustomer");
        String email = request.getParameter("emailCustomer");
        String address = request.getParameter("addressCustomer");
        String typeId = request.getParameter("typeIdCustomer");
        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, typeId);
        String message = this.customerBO.editCustomer(customer);
        List<CustomerType> customerTypeList=customerTypeBO.findAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        request.setAttribute("customer", customer);
        request.setAttribute("message", message);
        request.getRequestDispatcher("customer/editCustomer.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCustomer=request.getParameter("idCustomer");
        customerBO.deleteCustomer(idCustomer);
        this.displayCustomer(request,response);

    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idCustomer");
        String name = request.getParameter("nameCustomer");
        String birthday = request.getParameter("birthdayCustomer");
        String gender = request.getParameter("genderCustomer");
        String idCard = request.getParameter("idCardCustomer");
        String phone = request.getParameter("phoneCustomer");
        String email = request.getParameter("emailCustomer");
        String address = request.getParameter("addressCustomer");
        String typeId = request.getParameter("typeIdCustomer");
        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, typeId);
        String message = this.customerBO.createCustomer(customer);
        List<CustomerType> customerTypeList=customerTypeBO.findAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        request.setAttribute("customer", customer);
        request.setAttribute("message", message);
        request.getRequestDispatcher("customer/createCustomer.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionCustomer = request.getParameter("actionCustomer");
        switch (actionCustomer) {
            case "create":
                showCreateCustomerForm(request, response);
                break;
            case "edit":
                showEditCustomerForm(request, response);
                break;
            default:
                break;
        }

    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        String idCustomer=request.getParameter("idCustomer");
        Customer customer=customerBO.findCustomerById(idCustomer);
        List<CustomerType> customerTypeList=customerTypeBO.findAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        request.setAttribute("customer",customer);
        try {
            request.getRequestDispatcher("customer/editCustomer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList=customerTypeBO.findAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        try {
            request.getRequestDispatcher("customer/createCustomer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList=customerBO.findAllCustomer();
        String action=request.getParameter("action");
        request.setAttribute("action","customer");
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }
}
