package com.webservice.service;

import com.webservice.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void update(Customer customer);
    void deleteById(Integer id);
    Customer findById(Integer id);
}
