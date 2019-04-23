package com.tourfirm.service.impl;

import com.tourfirm.dao.RoomDAO;
import com.tourfirm.entity.Room;
import com.tourfirm.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private final RoomDAO roomDAO;

    public RoomServiceImpl(RoomDAO roomDAO) {
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
    public void save(Room room) {
        roomDAO.save(room);
    }

    @Override
    public void update(Room room) {
        Room roomDB = roomDAO.findById(room.getId());
        if (room.getId().equals(roomDB.getId())) {
            roomDAO.update(room);
        }
    }

    @Override
    public void delete(Room room) {
        roomDAO.delete(room);
    }
}
