package com.tourfirm;

import com.toufirm.Room;

import java.util.List;

public interface RoomDAO {

    Room findById(Long id);

    List<Room> findAllByHotelName(String hotelName);

    void save(Room room);

    void update(Room room);

    void delete(Room room);
}
