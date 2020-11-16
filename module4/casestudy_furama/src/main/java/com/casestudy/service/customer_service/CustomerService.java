package com.casestudy.service.customer_service;

import com.casestudy.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);
    void createCustomer(Customer customer);
    Customer findCustomerById(String id);
    void deleteCustomer(String id);
    void editCustomer(Customer customer);
    Page<Customer> findCustomerByName(String customerName,Pageable pageable);
    List<Customer> findAllCustomer();
}
