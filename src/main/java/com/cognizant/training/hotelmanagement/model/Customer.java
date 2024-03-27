package com.cognizant.training.hotelmanagement.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.ToString;

@Entity
@ToString
public class Customer {

    @Id
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String customer_id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String first_name;
    @Column(name = "last_name", nullable = false, length = 50)
    private String last_name;
    @Column(name = "phone_no", nullable = false, length = 15)
    private String phone_no;
    @Column(name = "mail", nullable = false, length = 50)
    private String mail;

    @OneToMany(mappedBy = "customer_id_fk")
    @JsonBackReference
    private List<Booking> bookings;

    // Constructors, getters, and setters

    public Customer() {
    }

    public Customer(String first_name, String last_name, String phone_no, String mail) {
        // this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_no = phone_no;
        this.mail = mail;
    }

    public Customer(String first_name, String last_name, String phone_no, String mail,
            List<Booking> bookings) {
        // this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_no = phone_no;
        this.mail = mail;
        this.bookings = bookings;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

}
