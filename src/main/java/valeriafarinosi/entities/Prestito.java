package valeriafarinosi.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestito {

    @Id
    @GeneratedValue
    @Column(name = "id_prestito")
    private UUID idPrestito;

    @ManyToOne
    @JoinColumn(name = "id_elemento")
    private Elementi elemento;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;

    //    inizialmente è null
    @Column(name = "data_restituzione_effettiva", nullable = true)
    private LocalDate dataRestituzioneEffettiva;

    protected Prestito() {
    }

    public Prestito(Utente utente, Elementi elemento) {
        this.utente = utente;
        this.elemento = elemento;
        this.dataInizioPrestito = LocalDate.now();
    }

    public UUID getIdPrestito() {
        return idPrestito;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataInizioPrestito.plusDays(30);
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "idPrestito=" + idPrestito +
                ", elemento=" + elemento +
                ", utente=" + utente +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
