package org.example;

import DAO.EventiDAO;
import DAO.PartecipazioneDAO;
import DAO.PersoneDAO;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4W3D2_pu");
        EntityManager em = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(em);
        Evento concerto = new Evento("Schubert live", "concerto di musica classica", tipoEvento.PUBBLICO, 500, "teatro");
        Evento esibizione = new Evento("Echo", "spettacolo del Cirque du Soleil", tipoEvento.PUBBLICO, 600, "circo");
        Evento mostra = new Evento("La seduzione della pittura", "Giovanni Boldini alla Cavallerizza di Piazzale verdi di Lucca", tipoEvento.PUBBLICO, 1000, "museo");

        ed.save(concerto);
        ed.save(esibizione);
        ed.save(mostra);

        PersoneDAO pd1 = new PersoneDAO(em);
        Persona rossella = new Persona("ros", "maru", "rosmaru@mail.com", 06, 02, 1994, sesso.F);
        Persona ettore = new Persona("etto", "delo", "edelo@mail.com", 01, 12, 1990, sesso.M);
        Persona rachel = new Persona("rache", "ledda", "racheledda@mail.com", 19, 01, 1990, sesso.NB);
        pd1.save(rossella);
        pd1.save(ettore);
        pd1.save(rachel);

        PartecipazioneDAO pd2 = new PartecipazioneDAO(em);
        Partecipazione p1 = new Partecipazione(rossella, esibizione);
        Partecipazione p2 = new Partecipazione(ettore, mostra);
        Partecipazione p3 = new Partecipazione(rachel, concerto);
        pd2.save(p1);
        pd2.save(p2);
        pd2.save(p3);
    }
}
