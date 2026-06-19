package valeriafarinosi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import valeriafarinosi.entities.Utente;
import valeriafarinosi.exceptions.UtenteNonTrovatoException;

import java.util.UUID;

public class UtentiDAO {

    private final EntityManager em;

    public UtentiDAO(EntityManager em) {
        this.em = em;
    }

    //    SAVE
    public void save(Utente newUtente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newUtente);

        transaction.commit();

        System.out.println("L'utente " + newUtente + " è stato salvato correttamente!");
    }

    //    FIND UTENTE BY ID
    public Utente findUtenteById(String idUtente) {
        Utente found = em.find(Utente.class, UUID.fromString(idUtente));

        if (found == null) throw new UtenteNonTrovatoException(idUtente);

        return found;
    }


}
