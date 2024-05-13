package com.hotelmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.model.Customer;
import com.hotelmanagement.repository.CustomerRepository;

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
    public String loginCustomer(String mail, String password) {
        // check the mail and passord string length
        if (mail.length() < 1 || password.length() < 1) {
            return "{\"success\":false,\"message\":\"fields can not be empty\"}";
        }
        Optional<Customer> response = customerRepository.findByMailAndPassword(mail,
                password);
        if (response.isPresent()) {
            return "{\"success\":true,\"data\":{\"customer_id\":" + response.get().getCustomer_id()
                    + ",\"first_name\":\""
                    + response.get().getFirst_name()
                    + "\",\"last_name\":\"" + response.get().getLast_name()
                    + "\",\"phone_no\":\"" + response.get().getPhone_no() + "\",\"mail\":\"" + response.get().getMail()
                    + "\"},\"message\":\"Logged in succefully\"}";
        } else {
            return "{\"success\":false,\"message\":\"mail or password is incorrect\"}";
        }
    }

}
