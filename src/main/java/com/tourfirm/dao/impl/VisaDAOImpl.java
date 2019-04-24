package com.tourfirm.dao.impl;

import com.tourfirm.dao.ClientDAO;
import com.tourfirm.dao.VisaDAO;
import com.tourfirm.entity.Client;
import com.tourfirm.entity.Visa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class VisaDAOImpl extends AbstractDAO<Visa, Integer> implements VisaDAO {


    protected VisaDAOImpl() {
        super(Visa.class);}

    @Autowired
    private ClientDAO clientDAO;
    @Override
    public Client findClientByName(String lastName) {
        final char dm = (char) 34;
        Query query = entityManager.createNativeQuery("SELECT Clients.id from Clients where Clients.lastname = "+ dm + lastName + dm + ";");
        Integer id= (Integer) query.getSingleResult();
        Client client = clientDAO.findById(id);
        return client;
    }

    @Override
    public List<Visa> findAllVisaByClient(String lastName) {
        Query query = entityManager.createQuery("SELECT visa FROM Visa visa " +
                "inner  join visa.client client where client.lastName=:lastName");
        query.setParameter("lastName",lastName);
        List<Visa> visaList= query.getResultList();
        return visaList;
    }

    @Override
    public List<Visa> findAllVisaByCountry(String countryName) {
        Query query = entityManager.createQuery("SELECT visa FROM Visa visa " +
                "inner  join visa.country country where country.countryName=:countryName");
        query.setParameter("countryName",countryName);
        List<Visa> visaList= query.getResultList();
        return visaList;
    }
}
