package com.tourfirm.service;

import com.tourfirm.entity.Room;

import java.util.List;

public interface RoomService {

    Room findById(Integer id);

    List<Room> finaAll();

    void save(Room room);

    void update(Room room);

    void delete(Room room);
}
