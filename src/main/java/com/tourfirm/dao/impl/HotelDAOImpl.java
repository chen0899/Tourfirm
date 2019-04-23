package com.tourfirm.dao.impl;

import com.tourfirm.dao.HotelDAO;
import com.tourfirm.entity.Hotel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class HotelDAOImpl extends AbstractDAO<Hotel, Long> implements HotelDAO {

    public HotelDAOImpl() {
        super(Hotel.class);
    }

    @Override
    public Hotel findByName(String hotelName) {
        Query query = entityManager.createQuery("SELECT hotel From Hotel hotel where hotel.hotelName=:hotelName");
        query.setParameter("hotelName", hotelName);
        return (Hotel) query.getSingleResult();
    }

    @Override
    public List<Hotel> findAllByCity(String city) {
        Query query = entityManager.createQuery("SELECT hotel FROM Hotel hotel " +
                "inner  join hotel.city city where city.cityName=:requiredCity");
        query.setParameter("requiredCity", city);
        List<Hotel> hotelList = query.getResultList();
        return hotelList;
    }
}
