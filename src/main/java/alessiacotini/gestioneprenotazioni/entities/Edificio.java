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
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID edificio_id;

    @Column(name = "nome")
    private String name;

    @Column(name= "indirizzo")
    private int price;

    @Column(name = "citta")
    private int citta;

}
