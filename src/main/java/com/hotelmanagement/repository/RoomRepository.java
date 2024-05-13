package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
