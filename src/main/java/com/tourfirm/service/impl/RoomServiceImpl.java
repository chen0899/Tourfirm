package com.tourfirm.service.impl;

import com.tourfirm.dao.RoomDAO;
import com.tourfirm.entity.Room;
import com.tourfirm.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public void save(Room room) {
        roomDAO.save(room);
    }

    @Override
    public void update(Room room) {
        Integer roomId = room.getId();
        Room roomDB = roomDAO.findById(roomId);
        if (roomId.equals(roomDB.getId())) {
            roomDAO.save(room);
        }
    }

    @Override
    public void delete(Room room) {
        roomDAO.delete(room);
    }
}
