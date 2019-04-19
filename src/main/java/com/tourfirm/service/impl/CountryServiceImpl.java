package com.tourfirm.service.impl;

import com.tourfirm.dao.CountryDAO;
import com.tourfirm.entity.Country;
import com.tourfirm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Override
    public void save(Country country) {
        countryDAO.save(country);
    }

    @Override
    public List<Country> finaAll() {
        return countryDAO.findAll();
    }

    @Override
    public Country findById(Integer id) {
        return countryDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        countryDAO.delete(countryDAO.findById(id));
    }
}
