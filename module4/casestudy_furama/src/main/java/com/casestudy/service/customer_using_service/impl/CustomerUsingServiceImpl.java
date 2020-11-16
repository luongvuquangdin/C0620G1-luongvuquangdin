package com.casestudy.service.customer_using_service.impl;

import com.casestudy.entity.customer_using.CustomerUsing;
import com.casestudy.repository.customer_using_repository.CustomerUsingRepository;
import com.casestudy.service.customer_using_service.CustomerUsingService;

import java.util.List;

public class CustomerUsingServiceImpl implements CustomerUsingService {
    CustomerUsingRepository customerUsingRepository;
    @Override
    public List<CustomerUsing> findAllCustomerUsing() {
//        return this.customerUsingDAO.findAllCustomerUsing();
        return null;
    }
}
