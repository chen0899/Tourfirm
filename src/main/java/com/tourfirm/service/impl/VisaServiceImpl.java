package com.tourfirm.service.impl;

import com.tourfirm.dao.VisaDAO;
import com.tourfirm.entity.Visa;
import com.tourfirm.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisaServiceImpl implements VisaService {

    @Autowired
    private VisaDAO visaDAO;

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
}
