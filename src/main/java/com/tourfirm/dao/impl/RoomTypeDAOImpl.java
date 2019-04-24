package com.tourfirm.dao.impl;

import com.tourfirm.dao.RoomTypeDAO;
import com.tourfirm.entity.RoomType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class RoomTypeDAOImpl extends AbstractDAO<RoomType, Integer> implements RoomTypeDAO {

    public RoomTypeDAOImpl() {
        super(RoomType.class);
    }

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public RoomType findByRoomType(String type) {
        Query query = entityManager.createQuery("SELECT t FROM RoomType t where t.type=:type");
        query.setParameter("type", type);
        return (RoomType) query.getSingleResult();
    }
}
