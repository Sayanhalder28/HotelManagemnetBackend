package com.cognizant.training.hotelmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.hotelmanagement.model.Staff;
import com.cognizant.training.hotelmanagement.repository.StaffRepository;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaffDetails() {
        return staffRepository.findAll();
    }

    public Optional<Staff> addStaff(String first_name, String last_name, String password, String mail,
            String position) {

        Staff newStaff = new Staff(first_name, last_name, password, mail, position);

        return Optional.ofNullable(staffRepository.save(newStaff));
    }

    public String loginStaff(String mail, String password) {
        Optional<Staff> response = staffRepository.findByMailAndPassword(mail, password);
        if (response.isPresent()) {
            return "Stuff successfully loged in . Id : "+ response.get().getStaff_ID();
        } else {
            return "null";
        }
    }

}
