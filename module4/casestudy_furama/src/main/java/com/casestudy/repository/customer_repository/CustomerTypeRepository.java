package com.casestudy.repository.customer_repository;


import com.casestudy.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}
