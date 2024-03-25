package com.cognizant.training.hotelmanagement.controller;

import java.util.List;
import com.cognizant.training.hotelmanagement.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.repository.RoomRepository;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/all-room-details")
    public List<Room> getMethodName() {
        return roomRepository.findAll();
    }
    
}
