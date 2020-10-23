package com.dinluong.service;

import com.dinluong.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void save(Customer customer);
    void update(Customer customer);
    void delete(Integer id);
}
