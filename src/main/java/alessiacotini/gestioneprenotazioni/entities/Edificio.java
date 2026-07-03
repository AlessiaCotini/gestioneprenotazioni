package alessiacotini.gestioneprenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID edificio_id;

    @Column(name = "nome")
    private String name;

    @Column(name= "indirizzo")
    private String indirizzo;

    @Column(name = "citta")
    private String citta;

    public Edificio(String name, String indirizzo, String citta) {
        this.name = name;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
}
