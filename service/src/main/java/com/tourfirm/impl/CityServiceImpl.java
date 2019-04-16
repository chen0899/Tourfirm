package com.tourfirm.impl;

import com.toufirm.City;
import com.tourfirm.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {
private  CityDAOImpl cityDAO = new CityDAOImpl();

    @Override
    public List<City> findAll() {

        return cityDAO.findAll();
    }

    @Override
    public void save(City city) {
        cityDAO.save(city);

    }

    @Override
    public void update(Integer id, City city) {
        cityDAO.update(id, city);
    }

    @Override
    public void delete(Integer id) {
        cityDAO.delete(id);

    }

    @Override
    public City getCityById(Integer id) {
        return cityDAO.getCityById(id);
    }
}
