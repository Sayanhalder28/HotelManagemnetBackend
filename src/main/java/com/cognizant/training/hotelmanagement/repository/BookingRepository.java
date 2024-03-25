package com.cognizant.training.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.training.hotelmanagement.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
