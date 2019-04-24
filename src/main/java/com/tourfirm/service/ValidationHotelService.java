package com.tourfirm.service;

public interface ValidationHotelService {

    boolean isPresentHotelByName(String hotelName, Integer city);

    boolean isPresentHotelByEmail(String email);

    boolean isPresentHotelByPhone(String phone);

    boolean isPresentHotelByAddress(String address, Integer city);
}
