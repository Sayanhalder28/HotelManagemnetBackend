package com.cognizant.training.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.training.hotelmanagement.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
