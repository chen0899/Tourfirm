package com.tourfirm.dao.impl;

import com.tourfirm.dao.GenericDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Illia Chenchak
 */
@Repository
public class AbstractDAO<T, ID> implements GenericDAO<T, ID> {

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
    public T findById(ID id) {
        return (T) entityManager.createQuery("from " + entityClass.getName() + " where id = " + id).getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("from " + entityClass.getName()).getResultList();
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
