package com.tourfirm.dao.impl;

import com.tourfirm.dao.RoomDAO;
import com.tourfirm.entity.Room;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoomDAOImpl extends AbstractDAO<Room, Integer> implements RoomDAO {
    public RoomDAOImpl(){
        super(Room.class);
    }
}
