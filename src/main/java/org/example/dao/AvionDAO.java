

package org.example.dao;

        import org.example.entities.Avion;
        import org.example.util.JPAConfig;

        import javax.persistence.EntityManager;
        import javax.persistence.EntityTransaction;

public class AvionDAO {
    private EntityManager entityManager;

    public AvionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public AvionDAO() {
        this.entityManager = JPAConfig.getEntityManagerFactory().createEntityManager();
    }

    public void addAvion(Avion avion) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(avion);
        transaction.commit();
    }
}

