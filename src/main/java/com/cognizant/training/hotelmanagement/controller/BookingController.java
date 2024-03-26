package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.model.Booking;
import com.cognizant.training.hotelmanagement.service.BookingService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all-booking-details")
    public List<Booking> getMethodName() {
        return bookingService.getAllBookingDetails();
    }

    @GetMapping("/make-booking")
    public String makeBooking() {
        return bookingService.makeBooking();
    }
}
