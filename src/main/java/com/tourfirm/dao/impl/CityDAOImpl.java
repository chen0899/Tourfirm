package com.tourfirm.dao.impl;

import com.tourfirm.dao.CityDAO;
import com.tourfirm.entity.City;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CityDAOImpl extends AbstractDAO<City, Integer> implements CityDAO {
    protected CityDAOImpl() {
        super(City.class);
    }
}
