package com.cognizant.training.hotelmanagement.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.training.hotelmanagement.model.Booking;
import com.cognizant.training.hotelmanagement.model.Customer;
import com.cognizant.training.hotelmanagement.model.Room;
import com.cognizant.training.hotelmanagement.repository.BookingRepository;
import com.cognizant.training.hotelmanagement.repository.CustomerRepository;
import com.cognizant.training.hotelmanagement.repository.RoomRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Booking> getAllBookingDetails() {
        return bookingRepository.findAll();
    }

    public String makeBooking(String customer_id, Integer room_id,
            String check_in_date, String check_out_date,
            boolean is_canceled) {

        if (customer_id == null || room_id == null || check_in_date == null || check_out_date == null)
            return "Invalid input";

        Optional<Customer> customer_details = Optional.ofNullable(customerRepository.findById(customer_id))
                .orElseThrow(() -> new IllegalArgumentException("Not an user"));

        Optional<Room> room_details = Optional.ofNullable(roomRepository.findById(room_id))
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        if (customer_details.isEmpty() || room_details.isEmpty()) {
            return "Customer or Room not found";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // convert check_in time into LocalDateTime
        LocalDateTime check_in = LocalDateTime.parse(check_in_date, formatter);

        // convert check_out time into LocalDateTime
        LocalDateTime check_out = LocalDateTime.parse(check_out_date, formatter);

        Booking newBooking = new Booking(customer_details.get(), room_details.get(), check_in, check_out, is_canceled);

        bookingRepository.save(newBooking);
        return "Booking done successfully";
    }
}
