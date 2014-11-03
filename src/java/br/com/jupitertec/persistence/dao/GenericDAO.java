/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jupitertec.persistence.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import static javax.persistence.Persistence.createEntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Rafael
 */
public class GenericDAO <T, I extends Serializable>{
    
    private static EntityManagerFactory entityManagerFactory = createEntityManagerFactory("AcademiaPU");

    private EntityManager entityManager;

    private EntityTransaction transaction;

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void save(T bean) {

        try {
            entityManager = getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(bean);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    public void merge(T bean) {
        try {
            entityManager = getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(bean);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void delete(T bean) {
        try {
            entityManager = getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(entityManager.merge(bean));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public T findById(Class<T> classe, I pk) {
        entityManager = getEntityManager();
        T tmp = entityManager.find(classe, pk);
        entityManager.close();
        return tmp;
    }

    @SuppressWarnings("unchecked")

    public List<T> list(Class<T> classe) {
        entityManager = getEntityManager();
        Query query = entityManager.createQuery("select o from " + classe.getSimpleName() + " o");
        List<T> tmp = query.getResultList();
        entityManager.close();
        return tmp;
    }
}
