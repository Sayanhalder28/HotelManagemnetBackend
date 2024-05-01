package com.cognizant.training.hotelmanagement.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public String makeBooking(Integer customer_id, Integer room_id,
            String check_in_date,
            boolean is_canceled) {

        Customer customer_details = customerRepository.findById(customer_id).orElseThrow(
                () -> new IllegalArgumentException("{\"success\":false,\"message\":\"User Not Found\"}"));

        Room room_details = roomRepository.findById(room_id).orElseThrow(
                () -> new IllegalArgumentException("{\"success\":false,\"message\":\"Room Not Found Succesfully\"}"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // convert check_in time into LocalDateTime
        LocalDateTime check_in = LocalDateTime.parse(check_in_date, formatter);

        Booking newBooking = new Booking(customer_details, room_details, check_in, is_canceled);

        bookingRepository.save(newBooking);

        room_details.setRoom_status("Booked");
        roomRepository.save(room_details);
        return "{\"success\":true,\"message\":\"Room Booked Succesfully\"}";
    }

    public List<Booking> getMyBooking(Integer customer_id) {

        Customer customer = customerRepository.findById(customer_id)
                .orElseThrow(() -> new IllegalArgumentException("No customer found"));

        List<Booking> bookings = Optional.ofNullable(customer.getBookings()).orElseThrow(
                () -> new IllegalArgumentException("No bookings found"));

        return bookings;

    }

    public String cancelBooking(Integer booking_id) {

        Optional<Booking> booking = bookingRepository.findById(booking_id);

        if (booking.isEmpty())
            return "{\"success\":false,\"message\":\"No booking found with the given Id\"}";

        Room room = booking.get().getRoom_id_fk();
        room.setRoom_status("Available");
        roomRepository.save(room);

        booking.get().setIs_canceled(true);
        bookingRepository.save(booking.get());
        return "{\"success\":true,\"message\":\"Booking canceled Succesfully\"}";
    }

    public String updateCheckout(Integer booking_id, String check_out_date) {

        Optional<Booking> booking = bookingRepository.findById(booking_id);

        if (booking.isEmpty())
            return "{\"success\":false,\"message\":\"No booking found with the given Id\"}";

        // fint the room to updatte its status to available
        Room room = booking.get().getRoom_id_fk();
        room.setRoom_status("Available");
        roomRepository.save(room);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // convert check_out time into LocalDateTime
        LocalDateTime check_out = LocalDateTime.parse(check_out_date, formatter);

        booking.get().setCheck_out_date(check_out);
        bookingRepository.save(booking.get());
        return "{\"success\":true,\"message\":\"Checkout date updated successfully\"}";
    }

}
