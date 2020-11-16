package com.casestudy.repository.customer_repository;

import com.casestudy.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findAllByCustomerNameContaining(String customerName, Pageable pageable);
}
