package com.tourfirm.service.impl;

import com.tourfirm.dao.CityDAO;
import com.tourfirm.entity.City;
import com.tourfirm.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;

    @Override
    public void save(City city) {
         cityDAO.save(city);
    }

    @Override
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    public City findById(Integer id) {
        return cityDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
         cityDAO.delete(cityDAO.findById(id));
    }
}
