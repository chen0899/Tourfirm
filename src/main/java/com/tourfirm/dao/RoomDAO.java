package com.tourfirm.dao;

import com.tourfirm.entity.Room;

import java.sql.Date;
import java.util.List;

public interface RoomDAO extends GenericDAO<Room, Integer> {
    List<Room> findAllByHotelId(Long hotelId);

    List<Room> findAllAvailalbe(Long hotelId, String startDate, String endDate);

}
