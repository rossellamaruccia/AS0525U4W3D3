package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "concerto")
@DiscriminatorValue("concerto")
public class Concerto extends Evento {
    @Column(name = "genere")
    private Genere genere;
    @Column(name = "in_streaming")
    private boolean in_streaming;

    public Concerto() {
    }

    public Concerto(String titolo, String descrizione, tipoEvento tipo_evento, int numero_max_partecipanti, Location location, Genere genere, boolean in_streaming) {
        super(titolo, descrizione, tipo_evento, numero_max_partecipanti, location);
        this.genere = genere;
        this.in_streaming = in_streaming;
    }
}
