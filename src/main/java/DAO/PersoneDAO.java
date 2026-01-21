package DAO;

import entities.Persona;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersoneDAO {
    private final EntityManager entityManager;

    public PersoneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona newPersona) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPersona);
        transaction.commit();
    }

    public Persona getById(long persona_id) {
        Persona found = entityManager.find(Persona.class, persona_id);
        if (found == null) throw new NotFoundException(persona_id);
        return found;
    }

    public void findByIdAndDelete(long persona_id) {
        Persona found = this.getById(persona_id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }
}
