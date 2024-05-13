package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}