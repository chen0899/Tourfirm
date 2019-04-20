package com.tourfirm.service.impl;

import com.tourfirm.dao.VisaDAO;
import com.tourfirm.entity.Visa;
import com.tourfirm.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaServiceImpl implements VisaService {

    @Autowired
    private VisaDAO visaDAO;

    @Override
    public Integer save(Visa visa) {
        return visaDAO.save(visa);
    }

    @Override
    public List<Visa> finaAll() {
        return visaDAO.getAll();
    }

    @Override
    public Visa findById(Integer id) {
        return visaDAO.findById(id);
    }

    @Override
    public Integer delete(Integer id) {
        return visaDAO.delete(visaDAO.findById(id));
    }
}
