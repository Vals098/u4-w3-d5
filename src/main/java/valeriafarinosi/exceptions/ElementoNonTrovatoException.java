package valeriafarinosi.exceptions;

public class ElementoNonTrovatoException extends RuntimeException {
    public ElementoNonTrovatoException(String idElemento) {
        super("L'elemento con id " + idElemento + " non è stato trovato!");
    }
}
