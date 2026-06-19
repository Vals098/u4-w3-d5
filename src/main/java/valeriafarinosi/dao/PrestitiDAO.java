package valeriafarinosi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import valeriafarinosi.entities.Prestito;
import valeriafarinosi.exceptions.PrestitoNonTrovatoException;

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
}
