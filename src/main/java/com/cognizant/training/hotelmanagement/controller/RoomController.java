package com.cognizant.training.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.hotelmanagement.dto.RoomRequest;
import com.cognizant.training.hotelmanagement.model.Room;
import com.cognizant.training.hotelmanagement.service.RoomService;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all-room-details")
    public List<Room> allRoomController() {
        return roomService.getAllRoomDetails();
    }

    @PostMapping("/add-room")
    public String addRoomController(@RequestBody RoomRequest roomRequest) {
        Integer staffId = roomRequest.getStaffId();
        String roomNo = roomRequest.getRoomNo();
        String roomType = roomRequest.getRoomType();
        String roomStatus = roomRequest.getRoomStatus();

        String response = roomService.addRoom(staffId, roomNo, roomType, roomStatus);

        return response;
    }

}
