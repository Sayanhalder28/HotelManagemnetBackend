package com.cognizant.training.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.training.hotelmanagement.model.Room;

public interface RoomRepository extends JpaRepository<Room, String> {

}
