package valeriafarinosi.exceptions;

public class RivistaNonTrovataException extends RuntimeException {
    public RivistaNonTrovataException(String idRivista) {
        super("La rivista con id " + idRivista + " non è stata trovata!");
    }
}
