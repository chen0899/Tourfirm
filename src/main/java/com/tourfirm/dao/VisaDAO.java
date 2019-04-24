package com.tourfirm.dao;

import com.tourfirm.entity.Client;
import com.tourfirm.entity.Visa;

import java.util.List;

public interface VisaDAO extends GenericDAO<Visa,Integer> {
    public Client findClientByName(String lastName);

    public List<Visa>  findAllVisaByClient (String lastName);
}
