package com.tourfirm;

import com.toufirm.Client;

import java.util.List;

public interface ClientService {

    Client getUserById(Integer id);

    List<Client> findAll();

    void save(Client client);

    void update (Client client);

    void delete (Integer id);

}
