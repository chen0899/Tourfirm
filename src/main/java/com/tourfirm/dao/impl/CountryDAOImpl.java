package com.tourfirm.dao.impl;

import com.tourfirm.entity.Country;
import com.tourfirm.dao.CountryDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Illia Chenchak
 */
@Repository
@Transactional
public class CountryDAOImpl extends AbstractDAO<Country, Integer> implements CountryDAO {

    public CountryDAOImpl() {
        super(Country.class);
    }
}
