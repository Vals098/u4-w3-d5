package valeriafarinosi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import valeriafarinosi.entities.Elementi;
import valeriafarinosi.entities.Libro;
import valeriafarinosi.entities.Rivista;
import valeriafarinosi.exceptions.ElementoNonTrovatoException;
import valeriafarinosi.exceptions.LibroNonTrovatoException;
import valeriafarinosi.exceptions.RivistaNonTrovataException;

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


}
