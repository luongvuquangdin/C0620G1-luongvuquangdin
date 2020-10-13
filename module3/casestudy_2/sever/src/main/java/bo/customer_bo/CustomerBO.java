package bo.customer_bo;

import model.customer.Customer;

import java.util.List;

public interface CustomerBO {
    List<Customer>  findAllCustomer();
    String createCustomer(Customer customer);
    Customer findCustomerById(String id);
    String deleteCustomer(String id);
    String editCustomer(Customer customer);
    List<Customer> findCustomerByName(String customerName);
}
