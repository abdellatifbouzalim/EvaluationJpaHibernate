package org.example.dao;

import org.example.entities.Vol;
import org.example.util.JPAConfig;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class VolDAO {
    private EntityManager entityManager;

    public VolDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public VolDAO() {
        this.entityManager = JPAConfig.getEntityManagerFactory().createEntityManager();
    }

    public List<Vol> getFlightsByAvion(int avionId) {
        TypedQuery<Vol> query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.avion.id = :avionId", Vol.class);
        query.setParameter("avionId", avionId);
        return query.getResultList();
    }

    public List<Vol> getFlightsByDepartureCity(String departureCity) {
        TypedQuery<Vol> query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.VD = :departureCity", Vol.class);
        query.setParameter("departureCity", departureCity);
        return query.getResultList();
    }

    public List<Vol> getFlightsByArrivalCityAndTimeRange(String arrivalCity, LocalDateTime startTime, LocalDateTime endTime) {
        TypedQuery<Vol> query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.VA = :arrivalCity " +
                "AND v.HD >= :startTime AND v.HA <= :endTime", Vol.class);
        query.setParameter("arrivalCity", arrivalCity);
        query.setParameter("startTime", startTime);
        query.setParameter("endTime", endTime);
        return query.getResultList();
    }

    public int countFlightsByPilote(int piloteId) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(v) FROM Vol v WHERE v.pilote.id = :piloteId", Long.class);
        query.setParameter("piloteId", piloteId);
        return query.getSingleResult().intValue();
    }

    public List<Vol> getFlightsBetweenDates(Date startDate, Date endDate) {
        TypedQuery<Vol> query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.HD BETWEEN :startDate AND :endDate", Vol.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    public void addVol(Vol vol) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(vol);
        transaction.commit();
    }
}
