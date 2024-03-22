package com.cognizant.training.hotelmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @Column(name = "customer_id", nullable = false, length = 20)
    private String customer_id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String first_name;
    @Column(name = "last_name", nullable = false, length = 50)
    private String last_name;
    @Column(name = "phone_no", nullable = false, length = 15)
    private String phone_no;
    @Column(name = "mail", nullable = false, length = 50)
    private String mail;

    // Constructors, getters, and setters

    public Customer() {
    }

    public Customer(String customer_id, String first_name, String last_name, String phone_no, String mail) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_no = phone_no;
        this.mail = mail;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
   
}
