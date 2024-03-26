package com.cognizant.training.hotelmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.hotelmanagement.model.Customer;
import com.cognizant.training.hotelmanagement.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomerDetails() {
        return customerRepository.findAll();
    }

    public Optional<Customer> addCustomer(String first_name, String last_name, String phone_no, String mail) {

        //check for the mail if already exist 

        Customer newCustomer = new Customer(first_name, last_name, phone_no, mail);
        return Optional.ofNullable(customerRepository.save(newCustomer));
    }

}
