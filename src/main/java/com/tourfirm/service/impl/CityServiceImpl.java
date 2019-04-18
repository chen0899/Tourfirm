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
    public Integer save(City city) {
        return cityDAO.save(city);
    }

    @Override
    public List<City> finaAll() {
        return cityDAO.getAll();
    }

    @Override
    public City findById(Integer id) {
        return cityDAO.findById(id);
    }

    @Override
    public Integer delete(Integer id) {
        return cityDAO.delete(cityDAO.findById(id));
    }
}
