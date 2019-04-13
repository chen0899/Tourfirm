package com.tourfirm;

import com.toufirm.Client;

import java.util.List;

public interface ClientDAO {

    Client getUserById(Integer id);

    List<Client> findAll();

    void save(Client client);

    void update (Integer id, Client client);

    void delete (Integer id);
}
