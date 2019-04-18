package com.tourfirm.service;

import com.tourfirm.entity.Visa;

import java.util.List;

public interface VisaService {

    Integer save(Visa visa);

    List<Visa> finaAll();

    Visa findById(Integer id);

    Integer delete(Integer id);
}
