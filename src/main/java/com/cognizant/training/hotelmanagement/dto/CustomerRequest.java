package com.cognizant.training.hotelmanagement.dto;

public class CustomerRequest {

    private String firstName;
    private String lastName;
    private String password;
    private String phoneNo;
    private String mail;

    // Constructors, getters, and setters

    public CustomerRequest() {
    }

    public CustomerRequest(String firstName, String lastName, String password, String phoneNo, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.mail = mail;
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
