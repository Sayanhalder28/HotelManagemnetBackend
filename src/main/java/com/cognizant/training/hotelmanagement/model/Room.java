package com.cognizant.training.hotelmanagement.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer room_id;
    @Column(name = "room_no", nullable = false, length = 20, unique = true)
    private String room_no;
    @Column(name = "room_type", nullable = false, length = 50)
    private String room_type;
    @Column(name = "room_status", nullable = false, length = 20)
    private String room_status;

    @OneToMany(mappedBy = "room_id_fk")
    @JsonBackReference
    private List<Booking> bookings;

    // Constructors

    public Room() {
    }

    public Room(String room_no, String room_type, String room_status) {
        this.room_no = room_no;
        this.room_type = room_type;
        this.room_status = room_status;
    }

    public Room(String room_no, String room_type, String room_status, List<Booking> bookings) {
        this.room_no = room_no;
        this.room_type = room_type;
        this.room_status = room_status;
        this.bookings = bookings;
    }

    // Getter and Setter methods

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_status() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

}