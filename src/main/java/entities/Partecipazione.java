package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long partecipazione_id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "titolo")
    private Evento evento;

    public Partecipazione() {
    }

    public long getPartecipazione_id() {
        return partecipazione_id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }
}
