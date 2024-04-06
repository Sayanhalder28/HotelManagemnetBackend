package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelmanagementApplicationController {

    @GetMapping("/")
    public String indexController() {
        return "Hotel Management Application";
    }
}