package com.cognizant.training.hotelmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.model.Booking;
import com.cognizant.training.hotelmanagement.model.Room;
import com.cognizant.training.hotelmanagement.service.RoomService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all-room-details")
    public List<Room> getMethodName() {
        return roomService.getAllRoomDetails();
    }

    @GetMapping("/add-room")
    public String getMethodName(@RequestParam String room_no, @RequestParam String room_type,
            @RequestParam String room_status) {

        Optional<Room> savedRoom = roomService.addRoom(room_no, room_type, room_status);

        if (savedRoom.isPresent()) {
            return savedRoom.get().getRoom_id().toString();
        } else
            return "Room registration failed";
    }

}
