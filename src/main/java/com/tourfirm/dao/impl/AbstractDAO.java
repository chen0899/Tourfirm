package com.tourfirm.dao.impl;

import com.tourfirm.dao.GenericDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Illia Chenchak
 */
@Repository
@Transactional
public class AbstractDAO<T, ID > implements GenericDAO<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractDAO() {
    }

    private Class<T> entityClass;

    protected AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findById(ID id, Class<T> objectClass) {
        return (T) entityManager.createQuery("from "+objectClass.getName()+"where id = "+id).getSingleResult();
    }

    @Override
    public List<T> findAll(Class<T> objectClass) {
        return entityManager.createQuery("from "+objectClass.getName()).getResultList();

    }

    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        T mergeEnity = entityManager.merge(entity);
        entityManager.remove(mergeEnity);
    }
}
