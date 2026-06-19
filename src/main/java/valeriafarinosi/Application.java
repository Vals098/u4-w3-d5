package valeriafarinosi;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import valeriafarinosi.dao.ElementiDAO;
import valeriafarinosi.dao.PrestitiDAO;
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
        PrestitiDAO pd = new PrestitiDAO(em);

//        NEW RECORDS
        Utente u1 = new Utente("Valeria", "Farinosi", LocalDate.of(1998, 05, 30), 7463);
        Utente u2 = new Utente("Giulio", "Cariglio", LocalDate.of(1967, 11, 03), 4387);

        Libro l1 = new Libro("KLSH9843TIHLK", "L'Alchimista", 1988, 208, "Paulo Coelho", Genere.ROMANZO);
        Libro l2 = new Libro("IFOEUEHGEKJJK", "Se questo è un uomo", 1947, 176, "Primo Levi", Genere.BIOGRAFICO);

        Rivista r1 = new Rivista("LFDUEFO873U", "Internazionale", 2026, 87, Periodicita.SETTIMANALE);
        Rivista r2 = new Rivista("LIE9235KJG9", "Focus", 2026, 134, Periodicita.MENSILE);

//       RECORDS FROM DB
//        Utente u1FromDB = ud.findUtenteById("1e7b5dd6-ca64-409c-ae66-36c86c2a192c");
//        Utente u2FromDB = ud.findUtenteById("e5be2b7c-1778-4da4-ab0f-d3b39e6e6778");
//
//        Libro l1FromDB = ed.findLibroById("821e932a-b0ae-4d5b-85d3-3e3354524318");
//        Libro l2FromDB = ed.findLibroById("ab8259c5-da3c-4be2-91aa-37da8f718be1");
//
//        Rivista r1FromDB = ed.findRivistaById("e15b3d06-d0aa-41db-b7ba-265e714d9d80");
//        Rivista r2FromDB = ed.findRivistaById("e87afbe0-9fa4-4958-a57e-c83a3e8f5145");


//        Prestito p1 = new Prestito(u1FromDB, l1FromDB);
//        Prestito p2 = new Prestito(u2FromDB, r1FromDB);

//           SAVE
//        ud.save(u1);
//        ud.save(u2);
//
//        ed.save(l1);
//        ed.save(l2);
//        ed.save(r1);
//        ed.save(r2);

//        pd.save(p1);
//        pd.save(p2);

//        GET ALL ELEMENTS
//        ed.getAllElements().forEach(System.out::println);


//        DELETE BY ISBN
//        ed.deleteByISBN("LIE9235KJG9");
//        try {
//            ed.deleteByISBN("LIE9235KJG9");
//
//            System.out.println("Elemento eliminato con successo!");
//
//        } catch (ElementoNonTrovatoException e) {
//            System.out.println(e.getMessage());
//        }

//        FIND BY ISBN
//        try {
//            Elementi elemento = ed.findByISBN("LIE9235KJG9");
//
//            System.out.println("Elemento trovato:");
//            System.out.println(elemento);
//
//        } catch (ElementoNonTrovatoException e) {
//            System.out.println(e.getMessage());
//        }

//        FIND BY ANNO PUBBLICAZIONE
//        try {
//            List<Elementi> elementi = ed.findByAnnoPubblicaizone(2026);
//
//            System.out.println("Elementi trovati:");
//            elementi.forEach(System.out::println);
//
//        } catch (ElementoNonTrovatoException e) {
//            System.out.println(e.getMessage());
//        }

//        FIND BY AUTORE
//        try {
//            List<Libro> elementi = ed.findByAuthor("Paulo Coelho");
//
//            System.out.println("Elementi trovati:");
//            elementi.forEach(System.out::println);
//
//        } catch (ElementoNonTrovatoException e) {
//            System.out.println(e.getMessage());
//        }

//        FIND BY TITOLO
//        try {
//            List<Elementi> elementi = ed.findByTitle("ist");
//
//            System.out.println("Elementi trovati:");
//            elementi.forEach(System.out::println);
//
//        } catch (ElementoNonTrovatoException e) {
//            System.out.println(e.getMessage());
//        }


    }
}
