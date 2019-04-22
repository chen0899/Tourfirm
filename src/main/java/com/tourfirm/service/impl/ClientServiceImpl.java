package com.tourfirm.service.impl;

import com.tourfirm.dao.ClientDAO;
import com.tourfirm.entity.Client;
import com.tourfirm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public void save(Client client) {
        clientDAO.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public Client findById(Integer id) {
        return clientDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        clientDAO.delete(clientDAO.findById(id));
    }
}
