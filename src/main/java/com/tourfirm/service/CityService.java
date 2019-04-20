package com.tourfirm.service;

import com.tourfirm.entity.City;

import java.util.List;

public interface CityService {

    void save(City city);

    List<City> findAll();

    City findById(Integer id);

    void delete(Integer id);
}
