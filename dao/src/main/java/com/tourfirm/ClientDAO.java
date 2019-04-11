package com.tourfirm;

import com.toufirm.Client;

import java.util.List;

public interface ClientDAO {

    Client getUserById(Integer id);

    List<Client> findAll();
}
