package com.tourfirm.impl;

import com.toufirm.Client;
import com.tourfirm.ClientDAO;
import com.tourfirm.ClientService;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO = new ClientDAOImpl();

    @Override
    public Client getUserById(Integer id) {
        return clientDAO.getUserById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public void save(Client client) {
        clientDAO.save(client);
    }

    @Override
    public void update(Client client) {
        clientDAO.update(client);
    }

    @Override
    public void delete(Integer id) {
        clientDAO.delete(id);
    }
}
