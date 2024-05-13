package com.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.BookingRequest;
import com.hotelmanagement.model.Booking;
import com.hotelmanagement.service.BookingService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all-booking-details")
    public List<Booking> getAllBookingController() {
        return bookingService.getAllBookingDetails();
    }

    @PostMapping("/make-booking")
    public String makeBookingController(@RequestBody BookingRequest request) {
        Integer customerId = request.getCustomerId();
        Integer roomId = request.getRoomId();
        String checkInDate = request.getCheckInDate();
        boolean isCanceled = request.isCanceled();

        checkInDate = checkInDate + " 12:00:00";

        return bookingService.makeBooking(customerId, roomId, checkInDate, isCanceled);
    }

    @PutMapping("/cancel-booking")
    public String cancelBookingController(@RequestBody BookingRequest request) {
        Integer bookingId = request.getBookingId();
        return bookingService.cancelBooking(bookingId);
    }

    @PutMapping("/update-checkout")
    public String updateCheckoutController(@RequestBody BookingRequest request) {
        Integer bookingId = request.getBookingId();
        String checkOutDate = request.getCheckOutDate();
        return bookingService.updateCheckout(bookingId, checkOutDate);
    }

    @GetMapping("/my-booking/{customer_id}")
    public List<Booking> myBookingController(@PathVariable Integer customer_id) {
        return bookingService.getMyBooking(customer_id);
    }
}
