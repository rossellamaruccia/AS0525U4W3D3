package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "partita di calcio")
@DiscriminatorValue("partita")
public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra_di_casa")
    private String squadraDiCasa;
    @Column(name = "squadra_ospite")
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, String descrizione, tipoEvento tipo_evento, int numero_max_partecipanti, Location location, String squadraDiCasa, String squadraOspite) {
        super(titolo, descrizione, tipo_evento, numero_max_partecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraOspite;

    }


}
