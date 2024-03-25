package com.cognizant.training.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.model.Staff;
import com.cognizant.training.hotelmanagement.repository.StaffRepository;

@RestController
public class HotelmanagementApplicationController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/")
    public List<Staff> getAllStuffDetails() {
        return staffRepository.findAll();
    }

    @GetMapping("/save")
    public Staff getMethodName() {
        Staff staff = new Staff("STF001", "sayan", "halder", "1234567890", "Manager");
        Staff savedStaffDetails = staffRepository.save(staff);
        return savedStaffDetails;
    }

}