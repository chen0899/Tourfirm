package com.tourfirm.dao.impl;

import com.tourfirm.entity.Country;
import com.tourfirm.dao.CountryDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Illia Chenchak
 */
@Repository
public class CountryDAOImpl extends AbstractDAO<Country, Integer> implements CountryDAO {
    public CountryDAOImpl() {
        super(Country.class);
    }

    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public Country findCountryByName(String countryName) {
        final char dm = (char) 34;

        Query query = entityManager.createNativeQuery("SELECT country.id from country where country.country_name = " + dm + countryName + dm + ";");
        Integer id = (Integer) query.getSingleResult();
        Country country = findById(id);
        System.out.println(country);
        return country;
    }
}
