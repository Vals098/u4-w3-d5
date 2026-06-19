package valeriafarinosi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import valeriafarinosi.entities.Prestito;

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
}
