package org.example.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConfig {
    private static final String PERSISTENCE_UNIT_NAME = "org.example.entities";
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }
}
