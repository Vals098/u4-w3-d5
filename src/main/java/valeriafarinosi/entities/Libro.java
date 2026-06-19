package valeriafarinosi.entities;


import jakarta.persistence.*;
import valeriafarinosi.enums.Genere;

@Entity
@DiscriminatorValue("LIBRO")
public class Libro extends Elementi {

//    id_elemento del padre

    @Column(name = "autore")
    private String autore;

    @Column(name = "genere")
    @Enumerated(EnumType.STRING)
    private Genere genere;

    protected Libro() {
    }

    public Libro(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, Genere genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public Genere getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }
}
