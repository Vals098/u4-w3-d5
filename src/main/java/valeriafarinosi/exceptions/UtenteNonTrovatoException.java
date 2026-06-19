package valeriafarinosi.exceptions;

public class UtenteNonTrovatoException extends RuntimeException {
    public UtenteNonTrovatoException(String idUtente) {
        super("L'utente con id " + idUtente + " non è stato trovato!");
    }
}
