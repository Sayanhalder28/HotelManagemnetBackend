package com.cognizant.training.hotelmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.hotelmanagement.model.Room;
import com.cognizant.training.hotelmanagement.model.Staff;

import com.cognizant.training.hotelmanagement.repository.RoomRepository;
import com.cognizant.training.hotelmanagement.repository.StaffRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StaffRepository staffRepository;

    public List<Room> getAllRoomDetails() {
        return roomRepository.findAll();
    }

    public String addRoom(Integer staff_id, String room_no, String room_type, String room_status) {

        // check whether the user is authorised to add new room

        Optional<Staff> staff_details = staffRepository.findById(staff_id);

        if (staff_details.isEmpty()) {
            return "User not found";
        } else {
            String position = staff_details.get().getPosition();
            System.out.println(position);
            if (!position.equals("Manager")) {
                return "User not authorised";
            } else {
                Room newRoom = new Room(room_no, room_type, room_status);
                Optional<Room> response = Optional.ofNullable(roomRepository.save(newRoom));
                if (response.isPresent()) {
                    return "Added room With id : " + response.get().getRoom_id();
                } else {
                    return "null";
                }
            }
        }

    }

}
