package com.i18n.service;

import com.i18n.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void save(Customer customer);
    void update(Customer customer);
    void delete(Integer id);
}
