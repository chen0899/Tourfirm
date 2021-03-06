package com.tourfirm.service.impl;

import com.tourfirm.dao.RoomTypeDAO;
import com.tourfirm.entity.RoomType;
import com.tourfirm.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeDAO roomTypeDAO;

    @Override
    public RoomType findByName(String type) {
        return roomTypeDAO.findByRoomType(type);
    }

    @Override
    public RoomType findById(Integer id) {
        return null;
    }

    @Override
    public List<RoomType> finaAll() {
        return roomTypeDAO.findAll();
    }

    @Override
    public void save(RoomType roomType) {
        roomTypeDAO.save(roomType);
    }

    @Override
    public void update(RoomType roomType) {
        roomTypeDAO.update(roomType);
    }

    @Override
    public void delete(RoomType roomType) {
        roomTypeDAO.delete(roomType);
    }
}
