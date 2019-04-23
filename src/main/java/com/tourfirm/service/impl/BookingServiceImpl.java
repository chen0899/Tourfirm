package com.tourfirm.service.impl;

import com.tourfirm.dao.BookingDAO;
import com.tourfirm.entity.Booking;
import com.tourfirm.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDAO bookingDAO;

    @Override
    public void save(Booking booking) {
        bookingDAO.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingDAO.findAll();
    }

    @Override
    public Booking findById(Integer id) {
        return bookingDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        bookingDAO.delete(bookingDAO.findById(id));
    }

    @Override
    public void update(Integer id, Booking booking) {
        Booking newBooking = booking;
        newBooking.setId(id);
        bookingDAO.update(newBooking);
    }
}
