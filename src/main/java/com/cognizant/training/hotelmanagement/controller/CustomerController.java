package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.model.Customer;
import com.cognizant.training.hotelmanagement.repository.CustomerRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all-customer-details")
    public List<Customer> getMethodName() {
        return customerRepository.findAll();
    }
    
    
}
