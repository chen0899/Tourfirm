package com.tourfirm.dao;

import com.tourfirm.entity.RoomType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoomTypeDAO extends GenericDAO<RoomType, Integer> {

    RoomType findByRoomType(String type);
}
