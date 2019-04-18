package com.tourfirm.dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    public T findById(ID id);

    public List<T> getAll();

    public ID save(T entity);

    public T update(T entity);

    public Integer delete(T entity);
}
