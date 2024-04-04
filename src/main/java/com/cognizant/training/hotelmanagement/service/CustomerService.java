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

    public Optional<Customer> addCustomer(String first_name, String password, String last_name, String phone_no,
            String mail) {

        Customer newCustomer = new Customer(first_name, last_name, password, phone_no, mail);
        return Optional.ofNullable(customerRepository.save(newCustomer));
    }

    // login service
    public String login(String mail, String password) {
        Optional<Customer> response = customerRepository.findByMailAndPassword(mail,
                password);
        if (response.isPresent()) {
            return "loged in successfully";
        } else {
            return "login failed";
        }
    }

}
