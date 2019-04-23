package com.tourfirm.service.impl;

import com.tourfirm.dao.HotelDAO;
import com.tourfirm.entity.Hotel;
import com.tourfirm.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public void save(Hotel hotel) {

    }

    @Override
    public void update(Hotel hotel) {

    }

    @Override
    public void delete(Hotel hotel) {

    }
}
