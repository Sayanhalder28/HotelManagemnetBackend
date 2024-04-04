package com.cognizant.training.hotelmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.training.hotelmanagement.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findByMailAndPassword(String mail, String password);

}
