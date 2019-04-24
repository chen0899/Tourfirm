package com.tourfirm.dao.impl;

import com.tourfirm.dao.ClientDAO;
import com.tourfirm.entity.Client;
import org.springframework.stereotype.Repository;


/**
 * Created by Illia Chenchak
 */
@Repository
public class ClientDAOImpl extends AbstractDAO<Client, Integer> implements ClientDAO {
    public ClientDAOImpl() {
        super(Client.class);
    }

}
