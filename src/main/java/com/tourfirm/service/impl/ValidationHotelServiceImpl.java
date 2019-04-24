package com.tourfirm.service.impl;

import com.tourfirm.dao.HotelDAO;
import com.tourfirm.service.ValidationHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationHotelServiceImpl implements ValidationHotelService {
    @Autowired
    private HotelDAO hotelDAO;

    public boolean isPresentHotelByName(String hotelName, Integer city) {
        return hotelDAO.findByNameAndCity(hotelName, city) != null;
    }

    public boolean isPresentHotelByEmail(String email) {
        return hotelDAO.findByEmail(email) != null;
    }

    public boolean isPresentHotelByPhone(String phone) {
        return hotelDAO.findByPhone(phone) != null;
    }

    public boolean isPresentHotelByAddress(String address, Integer city) {
        return hotelDAO.findByAddress(address, city) != null;
    }
}
