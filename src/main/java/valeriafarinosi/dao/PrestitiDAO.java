package valeriafarinosi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import valeriafarinosi.entities.Elementi;
import valeriafarinosi.entities.Prestito;
import valeriafarinosi.exceptions.PrestitoNonTrovatoException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PrestitiDAO {

    private final EntityManager em;

    public PrestitiDAO(EntityManager em) {
        this.em = em;
    }

    //    SAVE
    public void save(Prestito newPrestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newPrestito);

        transaction.commit();

        System.out.println("Il prestito " + newPrestito + " è stato salvato correttamente!");
    }


    //    FIND PRESTITO BY ID
    public Prestito findPrestitoById(String idPrestito) {
        Prestito found = em.find(Prestito.class, UUID.fromString(idPrestito));

        if (found == null) throw new PrestitoNonTrovatoException(idPrestito);

        return found;
    }

    //    FIND ELEMENTO IN PRESTITO BY NUMERO TESSERA
    public List<Elementi> findElemInPrestitoByTessera(int numeroTessera) {

        TypedQuery<Elementi> query = em.createQuery(
                "SELECT p.elemento FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL",
                Elementi.class
        );

        query.setParameter("numeroTessera", numeroTessera);

        List<Elementi> risultati = query.getResultList();

        if (risultati.isEmpty()) {
            throw new PrestitoNonTrovatoException("La tessera con numero " + numeroTessera + " non ha attualmente elementi in prestito.");
        }

        return risultati;

    }

//    FIND PRESTITI SCADUTI E NON ANCORA RESTITUITI

    public List<Prestito> findPrestitiScaduti() {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p " +
                        "WHERE p.dataInizioPrestito < :limite " +
                        "AND p.dataRestituzioneEffettiva IS NULL",
                Prestito.class
        );

        query.setParameter("limite", LocalDate.now().minusDays(30));

        return query.getResultList();
    }


}
