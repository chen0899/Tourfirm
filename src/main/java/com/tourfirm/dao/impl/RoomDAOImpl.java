package com.tourfirm.dao.impl;

import com.tourfirm.dao.RoomDAO;
import com.tourfirm.entity.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoomDAOImpl extends AbstractDAO<Room, Integer> implements RoomDAO {
    public RoomDAOImpl() {
        super(Room.class);
    }

    @Override
    public List<Room> findAllByHotelId(Long hotelId) {
        Query query = entityManager.createQuery("SELECT room FROM Room room " +
                "inner join room.hotel hotel where hotel.id=:hotelId");
        query.setParameter("hotelId", hotelId);
        List<Room> hotelList = query.getResultList();
        return hotelList;
    }

    @Override
    public Room findByRoomNumber(Integer roomNumber) {
        Query query = entityManager.createQuery("SELECT room FROM Room room where room.roomNumber=:roomNumber");
        query.setParameter("roomNumber", roomNumber);
        Room result = null;
        try {
            result = (Room) query.getSingleResult();
        } catch (NoResultException ex) {
        }
        return result;
    }
}
