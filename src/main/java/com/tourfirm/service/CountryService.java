package com.tourfirm.service;

import com.tourfirm.entity.Country;

import java.util.List;

public interface CountryService {

    void save(Country country);

    List<Country> findAll();

    Country findById(Integer id);

    void delete(Integer id);
}
