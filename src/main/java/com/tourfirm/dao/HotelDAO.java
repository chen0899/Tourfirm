package com.tourfirm.dao;

import com.tourfirm.entity.Hotel;

import java.util.List;

public interface HotelDAO extends GenericDAO<Hotel, Long> {

    Hotel findByName(String hotelName);

    List<Hotel> findAllByCity(String city);

    Hotel findByNameAndCity(String hotelName, Integer city);

    Hotel findByEmail(String email);

    Hotel findByPhone(String phone);

    Hotel findByAddress(String address, Integer city);
}
