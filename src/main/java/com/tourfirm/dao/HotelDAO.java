package com.tourfirm.dao;

import com.tourfirm.entity.Hotel;

import java.util.List;

public interface HotelDAO extends GenericDAO<Hotel, Long> {

    Hotel findByName(String hotelName);

    List<Hotel> findAllByCity(String city);
}
