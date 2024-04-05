package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.dto.CustomerRequest;
import com.cognizant.training.hotelmanagement.model.Customer;
import com.cognizant.training.hotelmanagement.service.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all-customer-details")
    public List<Customer> getMethodName() {
        return customerService.getAllCustomerDetails();
    }

    @PostMapping(value = "/register-customer", consumes = "application/json")
    public String registerCustomer(@RequestBody CustomerRequest CustomerRequest) {

        String first_name = CustomerRequest.getFirstName();
        String last_name = CustomerRequest.getLastName();
        String password = CustomerRequest.getPassword();
        String phone_no = CustomerRequest.getPhoneNo();
        String mail = CustomerRequest.getMail();
        
        Optional<Customer> savedCustomer = customerService.addCustomer(first_name, password, last_name, phone_no, mail);
        if (savedCustomer.isPresent()) {
            return savedCustomer.get().getCustomer_id();
        } else {
            return "Customer registration failed";
        }
    }

    @GetMapping("/login-customer/{mail}/{password}")
    public String loginCustomer(@PathVariable String mail,
            @PathVariable String password) {
        String customer = customerService.login(mail, password);
        return customer;
    }

}
