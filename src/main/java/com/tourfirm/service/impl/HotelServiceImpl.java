package com.tourfirm.service.impl;

import com.tourfirm.dao.HotelDAO;
import com.tourfirm.entity.Hotel;
import com.tourfirm.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    @Override
    public Hotel findByName(String hotelName) {
        return hotelDAO.findByName(hotelName);
    }

    @Override
    public Hotel findById(Long id) {
        return hotelDAO.findById(id);
    }

    @Override
    public List<Hotel> finaAll() {
        return hotelDAO.findAll();
    }

    @Override
    public List<Hotel> findAllByCity(String city) {
        return hotelDAO.findAllByCity(city);
    }

    @Override
    public void save(Hotel hotel) {
        hotelDAO.save(hotel);
    }

    @Override
    public void update(Hotel hotel) {
        Hotel hotelDB = hotelDAO.findById(hotel.getId());
        if (hotel.getId().equals(hotelDB.getId())) {
            hotelDAO.update(hotel);
        }
    }

    @Override
    public void delete(Hotel hotel) {
        hotelDAO.delete(hotel);
    }
}
