package com.tourfirm.impl;

import com.toufirm.Hotel;

import java.util.List;

public class HotelServiceImpl {

    private HotelDAOImpl hotelDAO = new HotelDAOImpl();


    public List<Hotel> findAll() {

        return hotelDAO.findAll();
    }


}
