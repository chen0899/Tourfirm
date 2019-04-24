package com.tourfirm.dao;

import com.tourfirm.entity.Client;
import com.tourfirm.entity.Visa;

import java.util.List;

public interface VisaDAO extends GenericDAO<Visa, Integer> {
    Client findClientByName(String lastName);

    List<Visa> findAllVisaByClient(String lastName);

    List<Visa> findAllVisaByCountry(String countryName);

}
