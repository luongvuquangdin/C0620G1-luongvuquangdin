package com.casestudy.service.customer_service.impl;

import com.casestudy.entity.customer.CustomerType;
import com.casestudy.repository.customer_repository.CustomerTypeRepository;
import com.casestudy.service.customer_service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
