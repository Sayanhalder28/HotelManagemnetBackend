package com.cognizant.training.hotelmanagement.controller;

import java.util.List;
import com.cognizant.training.hotelmanagement.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.repository.StaffRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/all-staff-details")
    public List<Staff> getMethodName() {
        return staffRepository.findAll();
    }
    
    
}
