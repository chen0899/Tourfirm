package com.tourfirm.dao.impl;

import com.tourfirm.dao.RoomDAO;
import com.tourfirm.entity.Room;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RoomDAOImpl extends AbstractDAO<Room, Integer> implements RoomDAO {
    public RoomDAOImpl(){
        super(Room.class);
    }

    @Override
    public List<Room> findAllByHotelId(Long hotelId) {
        Query query = entityManager.createQuery("SELECT r FROM Room r " +
                "inner join r.hotel h where h.id=:hotelId");
        query.setParameter("hotelId", hotelId);
        List<Room> hotelList = query.getResultList();
        return hotelList;
    }
}
