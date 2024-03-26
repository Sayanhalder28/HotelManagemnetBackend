package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.model.Customer;
import com.cognizant.training.hotelmanagement.repository.CustomerRepository;
import com.cognizant.training.hotelmanagement.service.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all-customer-details")
    public List<Customer> getMethodName() {
        return customerService.getAllCustomerDetails();
    }

    @GetMapping("/register-customer")
    public String getMethodName(@RequestParam String first_name, @RequestParam String last_name,
            @RequestParam String phone_no, @RequestParam String mail) {

        Optional<Customer> savedCustomer = customerService.addCustomer(first_name, last_name, phone_no, mail);
        if (savedCustomer.isPresent()) {
            return savedCustomer.get().getCustomer_id();
        } else
            return "Customer registration failed";
    }

}
