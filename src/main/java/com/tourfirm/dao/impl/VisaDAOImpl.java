package com.tourfirm.dao.impl;

import com.tourfirm.dao.VisaDAO;
import com.tourfirm.entity.Visa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VisaDAOImpl extends AbstractDAO<Visa, Integer> implements VisaDAO {
    protected VisaDAOImpl() {
        super(Visa.class);
    }
}
