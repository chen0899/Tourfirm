package com.tourfirm.service;

import com.tourfirm.entity.Room;

import java.sql.Date;
import java.util.List;

public interface RoomService {

    Room findById(Integer id);

    List<Room> finaAll();

    List<Room> findAllByHotelId(Long hotelId);

    void save(Integer roomNumber, Integer numberOfPlaces, String hotel, String roomType);

    void update(Integer id, Integer roomNumber, Integer numberOfPlaces, String hotel, String roomType);

    void delete(Room room);

    List<Room> findAllAvailalbe(Long hotelId, String startDate, String endDate);
}
