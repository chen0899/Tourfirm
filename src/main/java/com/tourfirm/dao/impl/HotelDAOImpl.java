package com.tourfirm.dao.impl;

import com.tourfirm.dao.HotelDAO;
import com.tourfirm.entity.Hotel;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
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

    @Override
    public Hotel findByNameAndCity(String hotelName, Integer city) {
        Query query = entityManager.createQuery("SELECT hotel FROM Hotel hotel " +
                "inner  join hotel.city city where city.id=:requiredCity " +
                "and hotel.hotelName=:hotelName");
        query.setParameter("requiredCity", city);
        query.setParameter("hotelName", hotelName);
        Hotel result = null;
        try {
            result = (Hotel) query.getSingleResult();
        } catch (NoResultException ex) {

        }
        return result;
    }

    @Override
    public Hotel findByEmail(String email) {
        Query query = entityManager.createQuery("SELECT hotel From Hotel hotel where hotel.email=:email");
        query.setParameter("email", email);
        Hotel result = null;
        try {
            result = (Hotel) query.getSingleResult();
        } catch (NoResultException ex) {

        }
        return result;
    }

    @Override
    public Hotel findByPhone(String phone) {
        Query query = entityManager.createQuery("SELECT hotel From Hotel hotel where hotel.phone=:phone");
        query.setParameter("phone", phone);
        Hotel result = null;
        try {
            result = (Hotel) query.getSingleResult();
        } catch (NoResultException ex) {
        }
        return result;
    }

    @Override
    public Hotel findByAddress(String address, Integer city) {
        Query query = entityManager.createQuery("SELECT hotel FROM Hotel hotel " +
                "inner  join hotel.city city where city.id=:requiredCity " +
                "and hotel.address=:address");
        query.setParameter("requiredCity", city);
        query.setParameter("address", address);
        Hotel result = null;
        try {
            result = (Hotel) query.getSingleResult();
        } catch (NoResultException ex) {
        }
        return result;
    }
}
