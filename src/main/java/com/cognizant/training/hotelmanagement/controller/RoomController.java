package com.cognizant.training.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.model.Room;
import com.cognizant.training.hotelmanagement.service.RoomService;


@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all-room-details")
    public List<Room> getMethodName() {
        return roomService.getAllRoomDetails();
    }

    @GetMapping("/add-room/{staff_id}/{room_no}/{room_type}/{room_status}")
    public String addRoom(@PathVariable String staff_id,
            @PathVariable String room_no,
            @PathVariable String room_type,
            @PathVariable String room_status) {

        String response = roomService.addRoom(staff_id, room_no, room_type, room_status);

        return response;
    }

}
