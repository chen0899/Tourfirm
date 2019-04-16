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
    public List<Room> findAllByHotelName(String hotelName) {
        return roomDAO.findAllByHotelName(hotelName);
    }

    @Override
    public void save(Room room, String hotelName, String type) {
        HotelDAO hotelDAO = new HotelDAOImpl();
        RoomTypeDAO roomTypeDAO = new RoomTypeDAOImpl();
        Hotel hotel = hotelDAO.findHotelByName(hotelName);
        RoomType roomType = roomTypeDAO.findByRoomType(type);
        System.out.println(hotel);
        System.out.println(roomType);

        room.setHotel(hotel);
        room.setRoomType(roomType);

        roomDAO.save(room);
    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void delete(Room room) {
        roomDAO.delete(room);
    }
}
