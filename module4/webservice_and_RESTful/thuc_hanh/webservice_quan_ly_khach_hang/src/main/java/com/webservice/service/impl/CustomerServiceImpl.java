package com.webservice.service.impl;

import com.webservice.entity.Customer;
import com.webservice.repository.CustomerRepository;
import com.webservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void deleteById(Integer id) {
        this.customerRepository.deleteById(id);

    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id).orElse(null);
    }
}
