package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HotelmanagementApplicationControler {

    @GetMapping("/")
    public String hello(){
        return "Hellow World hi";
    }
}