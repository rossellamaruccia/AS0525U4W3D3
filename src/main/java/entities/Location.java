package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long location_id;

    @Column(name = "nome", nullable = false, columnDefinition = "TEXT")
    private String nome;

    @Column(name = "città", nullable = false, columnDefinition = "TEXT")
    private String citta;

    @ManyToMany(mappedBy = "Location")
    private List<Evento> eventi = new ArrayList<>();

    public Location() {
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public long getLocation_id() {
        return location_id;
    }

    public String getNome() {
        return citta;
    }

    public void setNome(String new_nome) {
        this.nome = new_nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Evento> getEventi() {
        return eventi;
    }
}
