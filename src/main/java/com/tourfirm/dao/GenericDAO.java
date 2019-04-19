package com.tourfirm.dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    public T findById(ID id, Class<T> objectClass);

    public List<T> findAll(Class<T> objectClass);

    public void save(T entity);

    public T update(T entity);

    public void delete(T entity);
}
