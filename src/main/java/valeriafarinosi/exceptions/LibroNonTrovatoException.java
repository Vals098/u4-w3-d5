package valeriafarinosi.exceptions;

public class LibroNonTrovatoException extends RuntimeException {
    public LibroNonTrovatoException(String idLibro) {
        super("Il libro con id " + idLibro + " non è stato trovato!");
    }
}
