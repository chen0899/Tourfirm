package com.tourfirm.service;

import com.tourfirm.entity.Room;

import java.util.List;

public interface RoomService {

    Room findById(Integer id);

    List<Room> findAll();

    List<Room> findAllByHotelId(Long hotelId);

    Room findByRoomNumber(Integer roomNumber);

    void save(Room room);

    void update(Room room);

    void delete(Room room);

    List<Room> findAllAvailalbe(Long hotelId, String startDate, String endDate);
}
