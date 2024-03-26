package com.cognizant.training.hotelmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

// import jakarta.persistence.Table;

@Entity
@ToString
public class Staff {

    @Id
    @Column(name = "staff_id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String staff_id;

    @Column(name = "first_name" , nullable = false, length = 50)
    private String first_name;
    @Column(name = "last_name" , nullable = false, length = 50)
    private String last_name;
    @Column(name = "phone_no" , nullable = false, length = 15)
    private String phone_no;
    @Column(name = "position" , nullable = false, length = 50)
    private String position;

    public Staff() {
    }

    public Staff(String first_name, String last_name, String phone_no, String position) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_no = phone_no;
        this.position = position;
    }
    // getters and setters

    public String getStaff_ID() {
        return staff_id;
    }

    public void setStaff_ID(String staff_ID) {
        this.staff_id = staff_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
