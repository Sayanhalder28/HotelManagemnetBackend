package com.hotelmanagement.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false, length = 50)
    private Integer booking_id;

    @ManyToOne
    @JoinColumn(name = "customer_id_fk", nullable = false, referencedColumnName = "customer_id")
    @JsonManagedReference
    private Customer customer_id_fk;

    @ManyToOne
    @JoinColumn(name = "room_id_fk", nullable = false, referencedColumnName = "room_id")
    @JsonManagedReference
    private Room room_id_fk;

    @Column(name = "check_in_date", nullable = false)
    private LocalDateTime check_in_date;

    @Column(name = "check_out_date", nullable = true)
    private LocalDateTime check_out_date;

    @Column(name = "is_canceled", nullable = false)
    private boolean is_canceled;

    public Booking() {
    }

    public Booking(Customer customer_id_fk, Room room_id_fk, LocalDateTime check_in_date,
            boolean is_canceled) {
        this.customer_id_fk = customer_id_fk;
        this.room_id_fk = room_id_fk;
        this.check_in_date = check_in_date;
        this.is_canceled = is_canceled;
    }

    public Booking(Customer customer_id_fk, Room room_id_fk, LocalDateTime check_in_date,
            LocalDateTime check_out_date, boolean is_canceled) {
        this.customer_id_fk = customer_id_fk;
        this.room_id_fk = room_id_fk;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.is_canceled = is_canceled;
    }

    public Integer getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Integer booking_id) {
        this.booking_id = booking_id;
    }

    public Customer getCustomer_id_fk() {
        return customer_id_fk;
    }

    public void setCustomer_id_fk(Customer customer_id_fk) {
        this.customer_id_fk = customer_id_fk;
    }

    public Room getRoom_id_fk() {
        return room_id_fk;
    }

    public void setRoom_id_fk(Room room_id_fk) {
        this.room_id_fk = room_id_fk;
    }

    public LocalDateTime getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(LocalDateTime check_in_date) {
        this.check_in_date = check_in_date;
    }

    public LocalDateTime getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(LocalDateTime check_out_date) {
        this.check_out_date = check_out_date;
    }

    public boolean isIs_canceled() {
        return is_canceled;
    }

    public void setIs_canceled(boolean is_canceled) {
        this.is_canceled = is_canceled;
    }

}

// create table Booking (
// Booking_ID INT Primary key AUTO_INCREMENT ,
// customer_ID VARCHAR(10) ,
// room_ID varchar(10),
// check_IN_date datetime,
// check_out_date datetime,
// is_canceled bool,
// Foreign KEY (customer_ID) references customer(customer_ID),
// Foreign KEY (room_ID) references room(room_ID)
// );