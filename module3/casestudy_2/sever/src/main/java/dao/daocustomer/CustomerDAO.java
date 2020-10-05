package dao.daocustomer;

import model.modelcustomer.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAllCustomer();
    String createCustomer(Customer customer);
    Customer findCustomerById(String id);
    String deleteCustomer(String id);
    String editCustomer(Customer customer);
    List<Customer> findCustomerByName(String customerName);
}
