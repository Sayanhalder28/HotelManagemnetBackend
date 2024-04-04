package com.cognizant.training.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.model.Booking;
import com.cognizant.training.hotelmanagement.service.BookingService;

import java.util.List;
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
        public String makeBooking(@RequestParam String customer_id, @RequestParam String room_id,
                        @RequestParam String check_in_date, @RequestParam String check_out_date,
                        @RequestParam boolean is_canceled) {

                return bookingService.makeBooking(customer_id, room_id, check_in_date, is_canceled);

        }

        @GetMapping("/my-booking")
        public List<Booking> myBooking(@RequestParam String customer_id) {
            return bookingService.getMyBooking(customer_id);
        }

        @GetMapping("/cancel-booking")
        public String getMethodName(@RequestParam Integer booking_id) {
            return bookingService.cancelBooking(booking_id);
        }

        //update checkout date
        @GetMapping("/update-checkout")
        public String getMethodName(@RequestParam Integer booking_id, @RequestParam String check_out_date) {
            return bookingService.updateCheckout(booking_id, check_out_date);
        }
        
}
