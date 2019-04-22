package com.tourfirm.service;

import com.tourfirm.entity.Client;

import java.util.List;

public interface ClientService {

    void save(Client client);

    List<Client> findAll();

    Client findById(Integer id);

    void delete(Integer id);
}
