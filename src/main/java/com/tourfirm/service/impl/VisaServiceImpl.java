package com.tourfirm.service.impl;

import com.tourfirm.dao.ClientDAO;
import com.tourfirm.dao.CountryDAO;
import com.tourfirm.dao.VisaDAO;
import com.tourfirm.entity.Client;
import com.tourfirm.entity.Visa;
import com.tourfirm.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class VisaServiceImpl implements VisaService {

    @Autowired
    private VisaDAO visaDAO;
    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private CountryDAO countryDAO;


    @Override
    public void save(Visa visa) {
         visaDAO.save(visa);
    }

    @Override
    public List<Visa> findAll() {
        return visaDAO.findAll();
    }

    @Override
    public Visa findById(Integer id) {
        return visaDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
         visaDAO.delete(visaDAO.findById(id));
    }

    private Visa getVisa(Date startDate, Date endDate, String client, String country) {
        Visa visa = new Visa();
        visa.setStartDate(startDate);
        visa.setEndDate(endDate);
        visa.setClient(visaDAO.findClientByName(client));
        visa.setCountry(countryDAO.findCountryByName(country));
        return visa;
    }

    @Override
    public void update(Integer id, Date startDate, Date endDate, String client, String country) {
        Visa visaDB = visaDAO.findById(id);

        Visa updatedVisa = getVisa(startDate, endDate,client,country);
        updatedVisa.setId(id);

        if (updatedVisa.getId().equals(visaDB.getId())) {
            visaDAO.update(updatedVisa);
        }
    }

    @Override
    public void save(Date startDate, Date endDate, String client, String country) {
        Visa visa = getVisa( startDate,  endDate,  client,  country);
        visaDAO.save(visa);
    }

    @Override
    public void delete(Visa visa) {

    }

}
