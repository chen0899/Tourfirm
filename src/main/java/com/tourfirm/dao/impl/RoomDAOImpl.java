package com.tourfirm.dao.impl;

import com.tourfirm.dao.RoomDAO;
import com.tourfirm.entity.Room;
import org.springframework.stereotype.Repository;

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
        Query query = entityManager.createQuery("SELECT r FROM Room r " +
                "inner join r.hotel h where h.id=:hotelId");
        query.setParameter("hotelId", hotelId);
        List<Room> hotelList = query.getResultList();
        return hotelList;
    }

    @Override
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
