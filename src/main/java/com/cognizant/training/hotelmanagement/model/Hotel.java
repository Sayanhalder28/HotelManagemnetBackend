package com.cognizant.training.hotelmanagement.model;

public class Hotel {
    private int id;
    private String name;
    private String location;

    // Constructors, getters, and setters
    public Hotel() {}

    public Hotel(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
