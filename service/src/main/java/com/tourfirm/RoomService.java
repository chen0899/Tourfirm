package com.tourfirm;

import com.toufirm.Room;

import java.util.List;

public interface RoomService {

    Room findById(Long id);

    List<Room> findAllByHotelName(String hotelName);

    void save(Room room, String hotelName, String roomType);

    void update(Room room);

    void delete(Room room);
}
