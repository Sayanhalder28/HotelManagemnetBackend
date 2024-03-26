package com.cognizant.training.hotelmanagement.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.training.hotelmanagement.model.Customer;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomerTest() {
        Customer customer = new Customer();

        // customer.setCustomer_ID("CUST001");
        customer.setFirst_name("John");
        customer.setLast_name("Doe");
        customer.setPhone_no("1234567890");
        customer.setMail("any@gmail.com");

        Customer reponse = customerRepository.save(customer);
        System.out.println(reponse.toString());
    }

}
