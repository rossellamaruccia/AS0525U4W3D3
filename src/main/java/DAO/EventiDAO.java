package DAO;

import entities.Concerto;
import entities.Evento;
import entities.Genere;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public List<Concerto> getConcertiInStreaming(boolean streaming) {
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT concerto FROM Concerto concerto WHERE concerto.in_streaming = :isStreaming", Concerto.class);
        query.setParameter("isStreaming", streaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT concerto FROM Concerto concerto WHERE concerto.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }
}