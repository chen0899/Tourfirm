package com.tourfirm;

import com.toufirm.City;

import java.util.List;



public  interface CityService {

    List<City> findAll();

    void save(City city);

    void update(Integer id, City city);

    void delete(Integer id);

    City getCityById(Integer id);
}
