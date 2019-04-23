package com.tourfirm.dao.impl;

import com.tourfirm.dao.ClientDAO;
import com.tourfirm.dao.VisaDAO;
import com.tourfirm.entity.Client;
import com.tourfirm.entity.Visa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@Repository
public class VisaDAOImpl extends AbstractDAO<Visa, Integer> implements VisaDAO {


    protected VisaDAOImpl() {
        super(Visa.class);}

    @Autowired
    private ClientDAO clientDAO;
    @Override
    public Client findClientByName(String lastName) {
        final char dm = (char) 34;

        Query query = entityManager.createNativeQuery("SELECT clients.id from clients where clients.lastname = "+ dm + lastName + dm + ";");
        Integer id= (Integer) query.getSingleResult();
        Client client = clientDAO.findById(id);
        System.out.println(client);
        return client;
    }


}
