package com.cognizant.training.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.hotelmanagement.model.Booking;
import com.cognizant.training.hotelmanagement.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    
    public List<Booking> getAllBookingDetails() {
        return bookingRepository.findAll();
    }
    
    public String makeBooking() {
        return "Needed to be implemented";
    }
}
