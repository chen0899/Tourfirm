package com.tourfirm.service;

import com.tourfirm.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel findByName(String hotelName);

    Hotel findById(Long id);

    List<Hotel> finaAll();

    void save(Hotel roomType);

    void update(Hotel roomType);

    void delete(Hotel roomType);

    List<Hotel> findAllByCity(String cityName);
}
