package com.tourfirm.service.impl;

import com.tourfirm.dao.HotelDAO;
import com.tourfirm.dao.RoomDAO;
import com.tourfirm.dao.RoomTypeDAO;
import com.tourfirm.entity.Hotel;
import com.tourfirm.entity.Room;
import com.tourfirm.entity.RoomType;
import com.tourfirm.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private final HotelDAO hotelDAO;
    private final RoomTypeDAO roomTypeDAO;
    private final RoomDAO roomDAO;

    public RoomServiceImpl(HotelDAO hotelDAO, RoomTypeDAO roomTypeDAO, RoomDAO roomDAO) {
        this.hotelDAO = hotelDAO;
        this.roomTypeDAO = roomTypeDAO;
        this.roomDAO = roomDAO;
    }

    @Override
    public Room findById(Integer id) {
        return roomDAO.findById(id);
    }

    @Override
    public List<Room> finaAll() {
        return roomDAO.findAll();
    }

    @Override
    public List<Room> findAllByHotelId(Long hotelId) {
        return roomDAO.findAllByHotelId(hotelId);
    }

    @Override
    public void save(Integer roomNumber, Integer numberOfPlaces, String hotel, String roomType) {
        Room room = getRoom(roomNumber, numberOfPlaces, hotel, roomType);
        roomDAO.save(room);
    }

    @Override
    public void update(Integer id, Integer roomNumber, Integer numberOfPlaces, String hotel, String roomType) {
        Room roomDB = roomDAO.findById(id);
        Room updatedRoom = getRoom(roomNumber, numberOfPlaces, hotel, roomType);
        updatedRoom.setId(id);

        if (updatedRoom.getId().equals(roomDB.getId())) {
            roomDAO.update(updatedRoom);
        }
    }

    @Override
    public void delete(Room room) {
        roomDAO.delete(room);
    }

    private Room getRoom(Integer roomNumber, Integer numberOfPlaces, String hotel, String roomType) {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setNumberOfPlaces(numberOfPlaces);
        room.setHotel(getByHotelName(hotel));
        room.setRoomType(getRoomType(roomType));
        return room;
    }

    private Hotel getByHotelName(String hotel) {
        return hotelDAO.findByName(hotel);
    }

    private RoomType getRoomType(String roomType) {
        return roomTypeDAO.findByRoomType(roomType);
    }

    @Override
    public List<Room> findAllAvailalbe(Long hotelId, String startDate, String endDate) {
        return roomDAO.findAllAvailalbe(hotelId,startDate,endDate);
    }
}
