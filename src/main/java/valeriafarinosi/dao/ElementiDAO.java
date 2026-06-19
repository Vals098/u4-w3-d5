package valeriafarinosi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import valeriafarinosi.entities.Elementi;
import valeriafarinosi.entities.Libro;
import valeriafarinosi.entities.Rivista;
import valeriafarinosi.exceptions.ElementoNonTrovatoException;
import valeriafarinosi.exceptions.LibroNonTrovatoException;
import valeriafarinosi.exceptions.RivistaNonTrovataException;

import java.util.List;
import java.util.UUID;

public class ElementiDAO {

    private final EntityManager em;

    public ElementiDAO(EntityManager em) {
        this.em = em;
    }

    //    SAVE
    public void save(Elementi newElemento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newElemento);

        transaction.commit();

        System.out.println("L'elemento " + newElemento + " è stato salvato correttamente!");
    }

    //    FIND ELEMENT BY ID
    public Elementi findById(String idElemento) {
        Elementi found = em.find(Elementi.class, UUID.fromString(idElemento));
        // ovvero: SELECT * FROM elementi WHERE id = :idElemento

        if (found == null) throw new ElementoNonTrovatoException(idElemento);

        return found;
    }


    //    FIND LIBRO BY ID
    public Libro findLibroById(String idLibro) {
        Libro found = em.find(Libro.class, UUID.fromString(idLibro));
        // ovvero: SELECT * FROM elementi WHERE id = :idElemento

        if (found == null) throw new LibroNonTrovatoException(idLibro);

        return found;
    }


    //    FIND RIVISTA BY ID
    public Rivista findRivistaById(String idRivista) {
        Rivista found = em.find(Rivista.class, UUID.fromString(idRivista));
        // ovvero: SELECT * FROM elementi WHERE id = :idElemento

        if (found == null) throw new RivistaNonTrovataException(idRivista);

        return found;
    }


    //    GET ALL
    public List<Elementi> getAllElements() {
        TypedQuery<Elementi> query =
                em.createQuery(
                        "SELECT e FROM Elementi e",
                        Elementi.class);

        return query.getResultList();
    }

    //    DELETE BY ISBN
    public void deleteByISBN(String codiceISBN) {


        TypedQuery<Elementi> query = em.createQuery(
                "SELECT e FROM Elementi e WHERE e.codiceISBN = :isbn",
                Elementi.class
        );
        query.setParameter("isbn", codiceISBN);

        List<Elementi> risultati = query.getResultList();

        if (risultati.isEmpty()) {
            throw new ElementoNonTrovatoException(codiceISBN);
        }

        Elementi found = risultati.getFirst();


        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();

    }

    //    FIND BY ISBN
    public Elementi findByISBN(String codiceISBN) {

        TypedQuery<Elementi> query = em.createQuery(
                "SELECT e FROM Elementi e WHERE e.codiceISBN = :isbn",
                Elementi.class
        );

        query.setParameter("isbn", codiceISBN);

        List<Elementi> risultati = query.getResultList();

        if (risultati.isEmpty()) {
            throw new ElementoNonTrovatoException(codiceISBN);
        }

        return risultati.getFirst();
    }

    //    FIND BY ANNO DI PUBBLICAZIONE
    public List<Elementi> findByAnnoPubblicaizone(int annoPubblicazione) {

        TypedQuery<Elementi> query = em.createQuery(
                "SELECT e FROM Elementi e WHERE e.annoPubblicazione = :anno_pubblicazione",
                Elementi.class
        );

        query.setParameter("anno_pubblicazione", annoPubblicazione);

        List<Elementi> risultati = query.getResultList();

        if (risultati.isEmpty()) {
            throw new ElementoNonTrovatoException("Nessun elemento pubblicato nell'anno " + annoPubblicazione + " trovato.");
        }

        return risultati;
    }

    //    FIND BY AUTORE
    public List<Libro> findByAuthor(String autore) {

        TypedQuery<Libro> query = em.createQuery(
                "SELECT l FROM Libro l WHERE l.autore = :autore",
                Libro.class
        );

        query.setParameter("autore", autore);

        List<Libro> risultati = query.getResultList();

        if (risultati.isEmpty()) {
            throw new ElementoNonTrovatoException(autore);
        }

        return risultati;
    }

    //    FIND BY TITOLO
    public List<Elementi> findByTitle(String titolo) {

        TypedQuery<Elementi> query = em.createQuery(
                "SELECT e FROM Elementi e WHERE e.titolo LIKE :titolo",
                Elementi.class
        );

        query.setParameter("titolo", "%" + titolo + "%");

        List<Elementi> risultati = query.getResultList();

        if (risultati.isEmpty()) {
            throw new ElementoNonTrovatoException(titolo);
        }

        return risultati;
    }

}
