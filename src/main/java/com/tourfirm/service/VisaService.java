package com.tourfirm.service;

import com.tourfirm.entity.Visa;

import java.sql.Date;
import java.util.List;

public interface VisaService {

    void save(Visa visa);

    void update(Integer id, Date startDate, Date endDate, String client, String country);

    void save( Date startDate, Date endDate, String client, String country);

    void delete(Visa visa);

    List<Visa> findAll();

    Visa findById(Integer id);

    void delete(Integer id);

    List<Visa> findAllVisaByClient(String lastName);

    List<Visa> findAllVisaByCountry(String countryName);
}
