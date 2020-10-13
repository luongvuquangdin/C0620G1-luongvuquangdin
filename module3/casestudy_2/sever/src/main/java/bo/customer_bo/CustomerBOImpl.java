package bo.customer_bo;

import common.ValidateEmail;
import common.ValidateID;
import common.ValidateNumber;
import dao.customer_dao.CustomerDAO;
import dao.customer_dao.CustomerDAOImpl;
import model.customer.Customer;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO=new CustomerDAOImpl();

    @Override
    public List<Customer> findAllCustomer() {
        return customerDAO.findAllCustomer();
    }

    @Override
    public String createCustomer(Customer customer) {
        String message=null;
        boolean checkID= ValidateID.checkIdCustomer(customer.getCustomerId());
        boolean checkNumberPhone= ValidateNumber.checkPhone(customer.getCustomerPhone());
        boolean checkIdCard=ValidateNumber.checkIdCard(customer.getCustomerIdCard());
        boolean checkEmail= ValidateEmail.checkEmail(customer.getCustomerEmail());
        if (!checkID) message="Customer id format is KH-XXXX (X is number 0-9)";
        else if (!checkNumberPhone) message="Phone number format is 090XXXXXXX or 091XXXXXXX or (84)+90XXXXXXX or (84)+91XXXXXXX";
        else if (!checkIdCard) message="Customer id card format is XXXXXXXXX (X is number 0-9)";
        else if (!checkEmail) message="Email format is abc@gmail.com";
        else message = customerDAO.createCustomer(customer);
        return message;
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerDAO.findCustomerById(id);
    }

    @Override
    public String deleteCustomer(String id) {
        return customerDAO.deleteCustomer(id);
    }

    @Override
    public String editCustomer(Customer customer) {
        String message=null;
        boolean checkID= ValidateID.checkIdCustomer(customer.getCustomerId());
        boolean checkNumberPhone= ValidateNumber.checkPhone(customer.getCustomerPhone());
        boolean checkIdCard=ValidateNumber.checkIdCard(customer.getCustomerIdCard());
        boolean checkEmail= ValidateEmail.checkEmail(customer.getCustomerEmail());
        // check id
        if (!checkID) message="Customer id format is KH-XXXX (X is number 0-9)";
        //check number phone
        else if (!checkNumberPhone) message="Phone number format is 090XXXXXXX or 091XXXXXXX or (84)+90XXXXXXX or (84)+91XXXXXXX (X is number 0-9)";
        // check idCard
        else if (!checkIdCard) message="Customer id card format is XXXXXXXXX (X is number 0-9)";
        else if (!checkEmail) message="Email format is abc@gmail.com";
        else message = customerDAO.editCustomer(customer);
        return message;
    }

    @Override
    public List<Customer> findCustomerByName(String customerName) {
        return customerDAO.findCustomerByName(customerName);
    }
}
