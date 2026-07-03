package alessiacotini.gestioneprenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Prenotazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID prenotazione_id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_prenotazione")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postazione postazione_associata;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente_associato;
}
