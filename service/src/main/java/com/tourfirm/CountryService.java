package com.tourfirm;

import com.toufirm.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    void save(Country country);

    void update(Country country);

    void delete(Country country);
}

