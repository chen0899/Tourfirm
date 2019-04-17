package com.tourfirm.impl;

import com.toufirm.Hotel;
import com.toufirm.Room;
import com.toufirm.RoomType;
import com.tourfirm.HotelDAO;
import com.tourfirm.RoomDAO;
import com.tourfirm.RoomService;
import com.tourfirm.RoomTypeDAO;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO = new RoomDAOImpl();

    @Override
    public Room findById(Long id) {
        return roomDAO.findById(id);
    }

    @Override
    public List<Room> findAllByHotelName(String hotelName) {
        return roomDAO.findAllByHotelName(hotelName);
    }

    @Override
    public void save(Room room, String hotelName, String type) {
        room.setHotel(getHotel(hotelName));
        room.setRoomType(getRoomType(type));
        roomDAO.save(room);
    }

    @Override
    public void update(Room room, String hotelName, String type) {
        Room roomDB = roomDAO.findById(room.getId());
        if (roomDB.getId().equals(room.getId())){
            room.setHotel(getHotel(hotelName));
            room.setRoomType(getRoomType(type));
            roomDAO.update(room);
        }
    }

    @Override
    public void delete(Room room) {
        roomDAO.delete(room);
    }

    private RoomType getRoomType(String type) {
        RoomTypeDAO roomTypeDAO = new RoomTypeDAOImpl();
        return roomTypeDAO.findByRoomType(type);
    }

    private Hotel getHotel(String hotelName) {
        HotelDAO hotelDAO = new HotelDAOImpl();
        return hotelDAO.findHotelByName(hotelName);
    }
}
