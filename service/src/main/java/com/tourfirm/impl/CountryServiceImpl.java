package com.tourfirm.impl;

import com.toufirm.Country;
import com.tourfirm.CountryDAO;
import com.tourfirm.CountryService;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
public class CountryServiceImpl implements CountryService {

    private CountryDAO countryDAO = new CountryDAOImpl();

    @Override
    public List<Country> findAll() {
        return countryDAO.findAll();
    }

    @Override
    public void save(Country country) {
        countryDAO.save(country);
    }

    @Override
    public void update(Country country) {
        countryDAO.update(country);
    }

    @Override
    public void delete(Integer id ) {
        countryDAO.delete(id);
    }

    @Override
    public void findByCountryName(String countryName) {
        countryDAO.findByCountryName(countryName);
    }
}
