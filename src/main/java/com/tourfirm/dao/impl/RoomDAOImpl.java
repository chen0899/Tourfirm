package com.tourfirm.dao.impl;

import com.tourfirm.dao.RoomDAO;
import com.tourfirm.entity.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.Date;
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

    public List<Room> findAllAvailalbe(Long hotelId, String startDate, String endDate) {
        Query query = entityManager.createQuery("SELECT r FROM Booking b " +
                "inner join b.room r " +
                "inner join r.hotel h  " +
                "where h.id=?1 and ?2  between b.startDate and b.endDate");
        query.setParameter(1, hotelId);
        query.setParameter(2, Date.valueOf(startDate));
        List<Room> roomList = query.getResultList();
        return roomList;

    }
}
