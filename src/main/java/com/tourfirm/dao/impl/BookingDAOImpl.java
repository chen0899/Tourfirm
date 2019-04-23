package com.tourfirm.dao.impl;

import com.tourfirm.dao.BookingDAO;
import com.tourfirm.entity.Booking;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Illia Chenchak
 */
@Repository
public class BookingDAOImpl extends AbstractDAO<Booking, Integer> implements BookingDAO {
    public BookingDAOImpl() {
        super(Booking.class);
    }
}
