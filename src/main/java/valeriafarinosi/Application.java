package valeriafarinosi;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import valeriafarinosi.dao.ElementiDAO;
import valeriafarinosi.dao.UtentiDAO;
import valeriafarinosi.entities.Libro;
import valeriafarinosi.entities.Rivista;
import valeriafarinosi.entities.Utente;
import valeriafarinosi.enums.Genere;
import valeriafarinosi.enums.Periodicita;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        ElementiDAO ed = new ElementiDAO(em);
        UtentiDAO ud = new UtentiDAO(em);

        Utente u1 = new Utente("Valeria", "Farinosi", LocalDate.of(1998, 05, 30), 7463);
        Utente u2 = new Utente("Giulio", "Cariglio", LocalDate.of(1967, 11, 03), 4387);

        Libro l1 = new Libro("KLSH9843TIHLK", "L'Alchimista", 1988, 208, "Paulo Coelho", Genere.ALTRO);
        Libro l2 = new Libro("IFOEUEHGEKJJK", "Se questo è un uomo", 1947, 176, "Primo Levi", Genere.STORICO);

        Rivista r1 = new Rivista("LFDUEFO873U", "Internazionale", 2026, 87, Periodicita.SETTIMANALE);
        Rivista r2 = new Rivista("LIE9235KJG9", "Focus", 2026, 134, Periodicita.MENSILE);

//        ud.save(u1);
//        ud.save(u2);
//
//        ed.save(l1);
//        ed.save(l2);
//        ed.save(r1);
//        ed.save(r2);


    }
}
