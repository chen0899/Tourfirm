package com.tourfirm.dao;

import com.tourfirm.entity.RoomType;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeDAO extends GenericDAO<RoomType, Integer> {

    RoomType findByRoomType(String type);
}
