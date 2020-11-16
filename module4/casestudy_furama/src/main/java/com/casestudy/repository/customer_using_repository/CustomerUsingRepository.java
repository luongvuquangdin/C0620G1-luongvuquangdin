package com.casestudy.repository.customer_using_repository;


import com.casestudy.entity.customer_using.CustomerUsing;

import java.util.List;

public interface CustomerUsingRepository {
    List<CustomerUsing> findAllCustomerUsing();
}
