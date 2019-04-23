package com.tourfirm.dao;

import com.tourfirm.entity.Client;
import com.tourfirm.entity.Visa;

public interface VisaDAO extends GenericDAO<Visa,Integer> {
    public Client findClientByName(String lastName);
}
