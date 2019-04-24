package com.tourfirm.dao;

import com.tourfirm.entity.Room;

import java.util.List;

public interface RoomDAO extends GenericDAO<Room, Integer> {
    List<Room> findAllByHotelId(Long hotelId);

    Room findByRoomNumber(Integer roomNumber);

    List<Room> findAllAvailalbe(Long hotelId, String startDate, String endDate);

}

