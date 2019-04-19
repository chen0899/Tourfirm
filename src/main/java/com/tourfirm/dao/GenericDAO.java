package com.tourfirm.dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    public T findById(ID id);

    public List<T> findAll();

    public void save(T entity);

    public T update(T entity);

    public void delete(T entity);
}
