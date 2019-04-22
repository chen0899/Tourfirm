package com.tourfirm.service;

import com.tourfirm.entity.Visa;

import java.util.List;

public interface VisaService {

    void save(Visa visa);

    List<Visa> findAll();

    Visa findById(Integer id);

    void delete(Integer id);
}
