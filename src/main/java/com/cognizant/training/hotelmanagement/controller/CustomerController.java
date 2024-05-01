package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.dto.CustomerRequest;
import com.cognizant.training.hotelmanagement.model.Customer;
import com.cognizant.training.hotelmanagement.service.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all-customer-details")
    public List<Customer> allCustomerController() {
        return customerService.getAllCustomerDetails();
    }

    @PostMapping(value = "/register-customer")
    public String registerCustomerController(@RequestBody CustomerRequest CustomerRequest) {

        String first_name = CustomerRequest.getFirstName();
        String last_name = CustomerRequest.getLastName();
        String password = CustomerRequest.getPassword();
        String phone_no = CustomerRequest.getPhoneNo();
        String mail = CustomerRequest.getMail();

        Optional<Customer> savedCustomer = customerService.addCustomer(first_name, password, last_name, phone_no, mail);
        if (savedCustomer.isPresent()) {
            return "Regitered Customer ID : "+savedCustomer.get().getCustomer_id();
        } else {
            return "Customer registration failed";
        }
    }

    @PostMapping(value = "/login-customer")
    public String loginCustomerController(@RequestBody CustomerRequest CustomerRequest) {

        String mail = CustomerRequest.getMail();
        String password = CustomerRequest.getPassword();

        String customer = customerService.loginCustomer(mail, password);
        return customer;
    }

}
