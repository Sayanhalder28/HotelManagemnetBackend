package com.cognizant.training.hotelmanagement.controller;

import java.util.List;
import java.util.Optional;

import com.cognizant.training.hotelmanagement.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.service.StaffService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/all-staff-details")
    public List<Staff> getMethodName() {
        return staffService.getAllStaffDetails();
    }

    @GetMapping("/register-staff")
    public String getMethodName(@RequestParam String first_name, @RequestParam String last_name,
            @RequestParam String password,
            @RequestParam String mail, @RequestParam String position) {

        Optional<Staff> savedStaff = staffService.addStaff(first_name, last_name, password, mail, position);
        if (savedStaff.isPresent()) {
            return savedStaff.get().getStaff_ID();
        } else
            return "Staff registration failed";
    }

    @GetMapping("/login-staff")
    public String getMethodName(@RequestParam String mail, @RequestParam String password) {
        String userID = staffService.login(mail, password);
        return userID;
    }

}
