package com.tourfirm.dao;

import com.tourfirm.entity.Country;
import org.springframework.data.jpa.repository.Query;

public interface CountryDAO extends GenericDAO<Country, Integer> {

    public Country findCountryByName(String countryName);
}
