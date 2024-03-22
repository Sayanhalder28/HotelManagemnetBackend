package com.cognizant.training.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.training.hotelmanagement.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, String> {

}

