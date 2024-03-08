package org.example.dao;

import org.example.entities.Pilote;
import org.example.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PiloteDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;



    public PiloteDAO() {
        this.entityManagerFactory = JPAConfig.getEntityManagerFactory();
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void addPilote(Pilote pilote) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(pilote);
        transaction.commit();
    }
}
