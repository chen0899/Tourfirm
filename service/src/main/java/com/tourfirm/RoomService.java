package com.tourfirm;

import com.toufirm.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAllByHotelName(String hotelName);

    void save(Room room);

    void update(Room room);

    void delete(Room room);
}
