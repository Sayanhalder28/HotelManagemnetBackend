package com.cognizant.training.hotelmanagement.controller;

import java.util.List;
import java.util.Optional;

import com.cognizant.training.hotelmanagement.dto.StaffRequest;
import com.cognizant.training.hotelmanagement.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.service.StaffService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/all-staff-details")
    public List<Staff> allStaffController() {
        return staffService.getAllStaffDetails();
    }

    @PostMapping("/register-staff")
    public String registerStaffController(@RequestBody StaffRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String password = request.getPassword();
        String mail = request.getMail();
        String position = request.getPosition();

        Optional<Staff> savedStaff = staffService.addStaff(firstName, lastName, password, mail, position);
        if (savedStaff.isPresent()) {
            return "{\"success\":true,\"message\":\"Staff Registerd Succesfully\"}";
        } else {
            return "{\"success\":false,\"message\":\"Staff not registered . Please try again\"}";
        }
    }

    @PostMapping("/login-staff")
    public String loginStaffController(@RequestBody StaffRequest request) {
        String mail = request.getMail();
        String password = request.getPassword();

        String userID = staffService.loginStaff(mail, password);
        return userID;
    }

}
