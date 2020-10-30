package com.webservice.controllers;

import com.webservice.entity.Customer;
import com.webservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.UriComponentsContributor;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> viewListCustomer(){
        return new ResponseEntity<>(this.customerService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Integer id){
        Customer customer=this.customerService.findById(id);
        if (customer==null){
            System.out.println("Customer has id = " + id + " Not Content");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        this.customerService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewCustomer(@RequestBody Customer customer){
        this.customerService.save(customer);
//        HttpHeaders httpHeaders=new HttpHeaders();
//        httpHeaders.setLocation(uriComponentsBuilder.path("/infor/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Integer id,@RequestBody Customer customer){
        Customer customer1=this.customerService.findById(id);
        if (customer1 == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        customer1.setName(customer.getName());
        customer1.setAge(customer.getAge());
        customer1.setPhone(customer.getPhone());

        this.customerService.save(customer1);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
