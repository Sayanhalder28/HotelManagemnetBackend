package com.cognizant.training.hotelmanagement.repository;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.training.hotelmanagement.model.Staff;

@SpringBootTest
public class StaffRepositoryTest {

    @Autowired
    private StaffRepository staffRepository;

    @Test
    public void saveStaffTest() {
        Staff staff = new Staff();

        staff.setStaff_ID("STF001");
        staff.setFirst_name("John");
        staff.setLast_name("Doe");
        staff.setPhone_no("1234567890");
        staff.setPosition("Manager");

        Staff response = staffRepository.save(staff);

        System.out.println(response.toString());
    }

    @Test
    void updateUsingSaveMethod() {

        Staff staff = staffRepository.findById("STF001").get();
        staff.setFirst_name("Sayan");
        staff.setLast_name("Halder");

        Staff response = staffRepository.save(staff);

        System.out.println(response.toString());

    }

    @Test
    void saveAllMethod() {
        Staff staff1 = new Staff();
        staff1.setStaff_ID("STF002");
        staff1.setFirst_name("John");
        staff1.setLast_name("Doe");
        staff1.setPhone_no("1234567890");
        staff1.setPosition("Manager");

        Staff staff2 = new Staff();
        staff2.setStaff_ID("STF003");
        staff2.setFirst_name("John");
        staff2.setLast_name("Doe");
        staff2.setPhone_no("1234567890");
        staff2.setPosition("Manager");

        Staff staff3 = new Staff();
        staff3.setStaff_ID("STF004");
        staff3.setFirst_name("John");
        staff3.setLast_name("Doe");
        staff3.setPhone_no("1234567890");
        staff3.setPosition("Manager");

        List<Staff> response = staffRepository.saveAll(List.of(staff1, staff2, staff3));
        System.out.println(response.toString());
    }

}
