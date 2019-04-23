package com.tourfirm.service;

import com.tourfirm.entity.RoomType;

import java.util.List;

public interface RoomTypeService {

    RoomType findByName(String type);

    RoomType findById(Integer id);

    List<RoomType> finaAll();

    void save(RoomType roomType);

    void update(RoomType roomType);

    void delete(RoomType roomType);
}
