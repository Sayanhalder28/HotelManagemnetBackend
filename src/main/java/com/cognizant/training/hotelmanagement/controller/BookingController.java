package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.model.Booking;
import com.cognizant.training.hotelmanagement.model.Customer;
import com.cognizant.training.hotelmanagement.model.Room;
import com.cognizant.training.hotelmanagement.repository.CustomerRepository;
import com.cognizant.training.hotelmanagement.repository.RoomRepository;
import com.cognizant.training.hotelmanagement.service.BookingService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BookingController {

        @Autowired
        private BookingService bookingService;

        @GetMapping("/all-booking-details")
        public List<Booking> getAllBookingDetails() {
                return bookingService.getAllBookingDetails();
        }

        @GetMapping("/make-booking")
        public String makeBooking(@RequestParam String customer_id, @RequestParam Integer room_id,
                        @RequestParam String check_in_date, @RequestParam String check_out_date,
                        @RequestParam boolean is_canceled) {

                return bookingService.makeBooking(customer_id, room_id, check_in_date, check_out_date, is_canceled);

        }
}
