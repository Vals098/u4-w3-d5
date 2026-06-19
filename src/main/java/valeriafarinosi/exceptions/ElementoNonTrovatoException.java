package valeriafarinosi.exceptions;

public class ElementoNonTrovatoException extends RuntimeException {
    public ElementoNonTrovatoException(String idElemento) {
        super("L'elemento " + idElemento + " non è stato trovato!");
    }
}
