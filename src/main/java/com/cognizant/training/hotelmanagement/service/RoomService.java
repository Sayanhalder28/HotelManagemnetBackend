package com.cognizant.training.hotelmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.hotelmanagement.model.Room;
import com.cognizant.training.hotelmanagement.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRoomDetails() {
        return roomRepository.findAll();
    }

    public Optional<Room> addRoom(String room_no, String room_type, String room_status) {

        //check for the room if already exist 

        //save and return the result
        Room newRoom = new Room(room_no, room_type, room_status);
        return Optional.ofNullable(roomRepository.save(newRoom));  
    }

}
