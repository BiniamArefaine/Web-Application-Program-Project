package edu.miu.cs.dao;

import java.util.List;

public interface IGenericJpaDao<K, E> {
    void flush();
    E create(E entity);
    E update(E entity);
    void delete(E entity);
    E findById(K id);
    List<E> findAll();
    public void rollBack();
}
//