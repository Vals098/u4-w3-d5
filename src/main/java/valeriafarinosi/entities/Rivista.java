package valeriafarinosi.entities;


import jakarta.persistence.*;
import valeriafarinosi.enums.Periodicita;

@Entity
@DiscriminatorValue("RIVISTA")
public class Rivista extends Elementi {

//    id_elemento del parent

    @Column(name = "periodicita")
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    protected Rivista() {
    }

    public Rivista(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
