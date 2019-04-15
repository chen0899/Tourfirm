package com.tourfirm;

import com.toufirm.RoomType;

import java.util.List;

public interface RoomTypeDAO {

    RoomType findByRoomType(String type);

    List<RoomType> findAll();

    void save(RoomType roomType);

    void update(RoomType roomType);

    void delete(RoomType roomType);
}
