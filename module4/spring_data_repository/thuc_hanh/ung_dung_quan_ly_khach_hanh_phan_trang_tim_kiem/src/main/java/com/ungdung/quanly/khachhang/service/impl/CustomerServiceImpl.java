package com.ungdung.quanly.khachhang.service.impl;

import com.ungdung.quanly.khachhang.entity.Customer;
import com.ungdung.quanly.khachhang.repository.CustomerRepository;
import com.ungdung.quanly.khachhang.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Customer customer) {
        this.customerRepository.delete(customer);
    }

    @Override
    public void deleteById(Integer id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void edit(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllByNameContaining(Pageable pageable,String keyWord){
        return this.customerRepository.findAllByNameContaining(pageable,keyWord);
    }
}
