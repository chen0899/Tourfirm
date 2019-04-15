package com.tourfirm.impl;

import com.toufirm.RoomType;
import com.tourfirm.RoomTypeDAO;
import com.tourfirm.RoomTypeService;

import java.util.List;

public class RoomTypeServiceImpl implements RoomTypeService {

    private RoomTypeDAO roomType = new RoomTypeDAOImpl();

    @Override
    public RoomType findByRoomType(String type) {
        return roomType.findByRoomType(type);
    }

    @Override
    public List<RoomType> findAll() {
        return roomType.findAll();
    }

    @Override
    public void save(RoomType roomType) {
        this.roomType.save(roomType);
    }

    @Override
    public void update(RoomType roomType) {
        this.roomType.update(roomType);
    }

    @Override
    public void delete(RoomType roomType) {
        this.roomType.delete(roomType);
    }
}
