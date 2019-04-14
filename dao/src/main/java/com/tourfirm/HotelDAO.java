package com.tourfirm;

import com.toufirm.Hotel;

import java.util.List;

public interface HotelDAO {

    Hotel findHotelByName(String hotelName);

    List<Hotel> findAllByCity(String cityName);

    void save(Hotel hotel);

    void update(Hotel hotel);

    void delete(Hotel hotel);
}
