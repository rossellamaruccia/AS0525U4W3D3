package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Persone")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long persona_id;

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "data_nascita", nullable = false)
    private LocalDate data_nascita;
    @Column(name = "sesso", nullable = false)
    @Enumerated(EnumType.STRING)
    private sesso sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> partecipazioni = new ArrayList<>();

    public Persona() {
    }

    public Persona(String nome, String cognome, String email, int dd, int mm, int yyyy, sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_nascita = LocalDate.of(dd, mm, yyyy);
        this.sesso = sesso;
    }

    public long getPersona_id() {
        return persona_id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(int dd, int mm, int yyyy) {
        this.data_nascita = LocalDate.of(dd, mm, yyyy);
    }

    public sesso getSesso() {
        return sesso;
    }

    public void setSesso(sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }
}
