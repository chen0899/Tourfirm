package com.tourfirm.service;

import com.tourfirm.entity.City;

import java.util.List;

public interface CityService {

    Integer save(City city);

    List<City> finaAll();

    City findById(Integer id);

    Integer delete(Integer id);
}
