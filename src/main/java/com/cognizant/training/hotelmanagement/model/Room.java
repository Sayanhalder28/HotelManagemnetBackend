package com.cognizant.training.hotelmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id", nullable = false, length = 50)
    private String room_id;
    @Column(name = "room_no", nullable = false, length = 20)
    private String room_no;
    @Column(name = "room_type", nullable = false, length = 50)
    private String room_type;
    @Column(name = "room_status", nullable = false, length = 20)
    private String room_status;

    // Constructors

    public Room() {
    }

    public Room(String room_id, String room_no, String room_type, String room_status) {
        this.room_id = room_id;
        this.room_no = room_no;
        this.room_type = room_type;
        this.room_status = room_status;
    }

    // Getter and Setter methods

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
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
}