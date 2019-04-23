package com.tourfirm.dao.impl;

import com.tourfirm.dao.ClientDAO;
import com.tourfirm.dao.CountryDAO;
import com.tourfirm.entity.Client;
import com.tourfirm.entity.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
@Repository
public class ClientDAOImpl extends AbstractDAO<Client, Integer> implements ClientDAO {
    public ClientDAOImpl() {
        super(Client.class);
    }

}
