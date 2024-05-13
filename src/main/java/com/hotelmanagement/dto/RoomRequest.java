package com.hotelmanagement.dto;

public class RoomRequest {
    private Integer staffId;
    private String roomNo;
    private String roomType;
    private String roomStatus;

    // Constructors, getters, and setters

    public RoomRequest() {
    }
    
    // Getters and setters

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
