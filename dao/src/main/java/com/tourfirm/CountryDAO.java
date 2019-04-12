package com.tourfirm;

import com.toufirm.Country;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
public interface CountryDAO {

    Country getCountryById(Integer id);

    List<Country> findAll();

    void save (Country country);


}
