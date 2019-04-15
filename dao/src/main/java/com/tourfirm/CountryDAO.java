package com.tourfirm;

import com.toufirm.Country;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
public interface CountryDAO {

    Country findByCountryName(String countryName);

    Country getCountryById(Integer id);

    List<Country> findAll();

    void save (Country country);

    void update (Country country);

    void delete (Integer id);

}
