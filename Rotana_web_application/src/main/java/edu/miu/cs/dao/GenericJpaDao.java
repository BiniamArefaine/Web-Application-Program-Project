package edu.miu.cs.dao;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public  abstract class GenericJpaDao<K, E>  implements  IGenericJpaDao<K, E>{

    protected Class<E> entityClass;

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("click-me");

    protected EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    protected EntityTransaction transaction = manager.getTransaction();

    @Transactional
    public void flush() {
        transaction.begin();
        manager.flush();
        transaction.commit();
    }

    @SuppressWarnings("unchecked")
    public GenericJpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass
                .getActualTypeArguments()[1];
    }

    public E create(E entity) {
        transaction.begin();
        manager.persist(entity);
        transaction.commit();
        return entity;
    }//

    public E update(E entity) {
        transaction.begin();
        manager.merge(entity);
        transaction.commit();
        return entity;
    }

    public void delete(E entity) {
        transaction.begin();
        manager.remove(entity);
        transaction.commit();
    }

    public E findById(K id) {
        transaction.begin();
        E entity = manager.find(entityClass, id);
        transaction.commit();
        return  entity;
    }

    public void rollBack() {
        transaction.begin();
        manager.getTransaction().rollback();
        transaction.commit();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List findAll() {
        String query = "from " + entityClass.getName() + " c";
        Query q = manager.createQuery(query);
        return q.getResultList();
    }
}
