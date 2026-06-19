package valeriafarinosi.exceptions;

public class PrestitoNonTrovatoException extends RuntimeException {
    public PrestitoNonTrovatoException(String idPrestito) {
        super("Il prestito con id " + idPrestito + " non è stato trovato!");
    }
}
