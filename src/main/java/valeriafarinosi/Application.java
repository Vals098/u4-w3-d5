package valeriafarinosi;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import valeriafarinosi.dao.ElementiDAO;
import valeriafarinosi.dao.PrestitiDAO;
import valeriafarinosi.dao.UtentiDAO;
import valeriafarinosi.entities.Libro;
import valeriafarinosi.entities.Prestito;
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
        PrestitiDAO pd = new PrestitiDAO(em);

        Utente u1 = new Utente("Valeria", "Farinosi", LocalDate.of(1998, 05, 30), 7463);
        Utente u2 = new Utente("Giulio", "Cariglio", LocalDate.of(1967, 11, 03), 4387);

        Libro l1 = new Libro("KLSH9843TIHLK", "L'Alchimista", 1988, 208, "Paulo Coelho", Genere.ALTRO);
        Libro l2 = new Libro("IFOEUEHGEKJJK", "Se questo è un uomo", 1947, 176, "Primo Levi", Genere.STORICO);

        Rivista r1 = new Rivista("LFDUEFO873U", "Internazionale", 2026, 87, Periodicita.SETTIMANALE);
        Rivista r2 = new Rivista("LIE9235KJG9", "Focus", 2026, 134, Periodicita.MENSILE);

//        FROM DB

        Utente u1FromDB = ud.findUtenteById("73cdc9d2-adeb-4c6d-9242-ff48ff8b532a");
        Utente u2FromDB = ud.findUtenteById("6022f819-c55b-462a-bc6c-e1bf9700fd6b");

        Libro l1FromDB = ed.findLibroById("8f8d6832-096f-4f5e-a169-f77aa6cee2ee");
        Libro l2FromDB = ed.findLibroById("291a1ddb-ffd3-4c9f-bc90-048b18ef62f8");


        Prestito p1 = new Prestito(u1FromDB, l1FromDB);


//        ud.save(u1);
//        ud.save(u2);
//
//        ed.save(l1);
//        ed.save(l2);
//        ed.save(r1);
//        ed.save(r2);

        pd.save(p1);


    }
}
