package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.model.Booking;
import com.cognizant.training.hotelmanagement.service.BookingService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all-booking-details")
    public List<Booking> getAllBookingDetails() {
        return bookingService.getAllBookingDetails();
    }

    @GetMapping("/make-booking/{customer_id}/{room_id}/{check_in_date}/{is_canceled}")
    public String makeBooking(@PathVariable String customer_id,
            @PathVariable String room_id,
            @PathVariable String check_in_date,
            @PathVariable boolean is_canceled) {
        // Call the bookingService to make the booking
        return bookingService.makeBooking(customer_id, room_id, check_in_date, is_canceled);
    }

    @GetMapping("/my-booking/{customer_id}")
    public List<Booking> myBooking(@PathVariable String customer_id) {
        return bookingService.getMyBooking(customer_id);
    }

    @GetMapping("/cancel-booking/{booking_id}")
    public String cancelBooking(@PathVariable Integer booking_id) {
        return bookingService.cancelBooking(booking_id);
    }

    @GetMapping("/update-checkout/{booking_id}/{check_out_date}")
    public String updateCheckout(@PathVariable Integer booking_id,
            @PathVariable String check_out_date) {
        return bookingService.updateCheckout(booking_id, check_out_date);
    }

}
