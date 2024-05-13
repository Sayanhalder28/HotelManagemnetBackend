package com.hotelmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByMailAndPassword(String mail, String password);

}
