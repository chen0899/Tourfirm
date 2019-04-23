package com.tourfirm.service;

import com.tourfirm.entity.Booking;

import java.util.List;

public interface BookingService {

    void save(Booking booking);

    List<Booking> findAll();

    Booking findById(Integer id);

    void delete(Integer id);

    void update(Integer id, Booking booking);
}
