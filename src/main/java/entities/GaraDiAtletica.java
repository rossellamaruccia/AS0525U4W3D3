package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "gara_di_atletica")
@DiscriminatorValue("gara")

public class GaraDiAtletica extends Evento {
    @Column(name = "set_atleti")
    private List<Persona> set_atleti;
    @Column(name = "atleta_vincente")
    private Persona atleta_vincente;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, String descrizione, tipoEvento tipo_evento, int numero_max_partecipanti, Location location, Persona atleta_vincente) {
        super(titolo, descrizione, tipo_evento, numero_max_partecipanti, location);
        this.atleta_vincente = atleta_vincente;
    }

}
