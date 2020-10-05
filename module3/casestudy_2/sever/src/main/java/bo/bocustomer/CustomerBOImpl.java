package bo.bocustomer;

import dao.daocustomer.CustomerDAO;
import dao.daocustomer.CustomerDAOImpl;
import model.modelcustomer.Customer;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO=new CustomerDAOImpl();

    @Override
    public List<Customer> findAllCustomer() {
        return customerDAO.findAllCustomer();
    }

    @Override
    public String createCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
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
        return customerDAO.editCustomer(customer);
    }

    @Override
    public List<Customer> findCustomerByName(String customerName) {
        return customerDAO.findCustomerByName(customerName);
    }
}
