package com.tourfirm.service;

import com.tourfirm.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel findByName(String hotelName);

    Hotel findById(Long id);

    List<Hotel> finaAll();

    List<Hotel> findAllByCity(String city);

    Hotel findByNameAndCity(String hotelName, Integer city);

    Hotel findByEmail(String email);

    Hotel findByPhone(String phone);

    Hotel findByAddress(String address, Integer city);

    void save(Hotel hotel);

    void update(Hotel hotel);

    void delete(Hotel hotel);

}
