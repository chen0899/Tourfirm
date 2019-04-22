package com.tourfirm.dao.impl;

import com.tourfirm.entity.Country;
import com.tourfirm.dao.CountryDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Illia Chenchak
 */
@Repository
@Transactional
public class CountryDAOImpl extends AbstractDAO<Country, Integer> implements CountryDAO {
    public CountryDAOImpl() {
        super(Country.class);
    }

    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public Country findCountryByName(String countryName) {
        return  (Country) entityManager.createQuery("from "+Country.class+" where country_name = "+countryName).getSingleResult();
    }
}
