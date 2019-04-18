package com.tourfirm.service;

import com.tourfirm.entity.Country;

import java.util.List;

public interface CountryService {

    Integer save(Country country);

    List<Country> finaAll();

    Country findById(Integer id);

    Integer delete(Integer id);
}
