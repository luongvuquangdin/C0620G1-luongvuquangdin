package com.ungdung.quanly.khachhang.service;


import com.ungdung.quanly.khachhang.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(Pageable pageable,String customerName);
    Customer findById(Integer id);
    void delete(Customer customer);
    void deleteById(Integer id);
    void save(Customer customer);
    void edit(Customer customer);
}
