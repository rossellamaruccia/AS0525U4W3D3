package DAO;

import entities.Evento;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {
    private final EntityManager entityManager;

    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvento);
        transaction.commit();
    }

    public Evento getById(long IDevento) {
        Evento found = entityManager.find(Evento.class, IDevento);
        if (found == null) throw new NotFoundException(IDevento);
        return found;
    }

    public void findByIdAndDelete(long IDevento) {
        Evento found = this.getById(IDevento);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }
}