package com.casestudy.service.customer_service.impl;

import com.casestudy.entity.customer.Customer;
import com.casestudy.repository.customer_repository.CustomerRepository;
import com.casestudy.service.customer_service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void createCustomer(Customer customer) {
//        String message=null;
//        boolean checkID= ValidateID.checkIdCustomer(customer.getCustomerId());
//        boolean checkNumberPhone= ValidateNumber.checkPhone(customer.getCustomerPhone());
//        boolean checkIdCard=ValidateNumber.checkIdCard(customer.getCustomerIdCard());
//        boolean checkEmail= ValidateEmail.checkEmail(customer.getCustomerEmail());
//        if (!checkID) message="Customer id format is KH-XXXX (X is number 0-9)";
//        else if (!checkNumberPhone) message="Phone number format is 090XXXXXXX or 091XXXXXXX or (84)+90XXXXXXX or (84)+91XXXXXXX";
//        else if (!checkIdCard) message="Customer id card format is XXXXXXXXX (X is number 0-9)";
//        else if (!checkEmail) message="Email format is abc@gmail.com";
//        else message = customerRepository.save(customer);
//        return message;
        this.customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void editCustomer(Customer customer) {
//        String message=null;
//        boolean checkID= ValidateID.checkIdCustomer(customer.getCustomerId());
//        boolean checkNumberPhone= ValidateNumber.checkPhone(customer.getCustomerPhone());
//        boolean checkIdCard=ValidateNumber.checkIdCard(customer.getCustomerIdCard());
//        boolean checkEmail= ValidateEmail.checkEmail(customer.getCustomerEmail());
//        // check id
//        if (!checkID) message="Customer id format is KH-XXXX (X is number 0-9)";
//        //check number phone
//        else if (!checkNumberPhone) message="Phone number format is 090XXXXXXX or 091XXXXXXX or (84)+90XXXXXXX or (84)+91XXXXXXX (X is number 0-9)";
//        // check idCard
//        else if (!checkIdCard) message="Customer id card format is XXXXXXXXX (X is number 0-9)";
//        else if (!checkEmail) message="Email format is abc@gmail.com";
//        else message = customerRepository.editCustomer(customer);
//        return message;
        this.customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findCustomerByName(String customerName,Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(customerName,pageable);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return this.customerRepository.findAll();
    }
}
