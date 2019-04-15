package com.tourfirm.impl;

import com.toufirm.Room;
import com.tourfirm.RoomDAO;
import com.tourfirm.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private RoomDAO room = new RoomDAOImpl();

    @Override
    public List<Room> findAllByHotelName(String hotelName) {
        return room.findAllByHotelName(hotelName);
    }

    @Override
    public void save(Room room) {

    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void delete(Room room) {

    }
}
