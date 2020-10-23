package com.khachhang.diachi.service;

import com.khachhang.diachi.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void delete(Customer customer);
    void deleteById(Integer id);
    void save(Customer customer);
    void edit(Customer customer);
}
