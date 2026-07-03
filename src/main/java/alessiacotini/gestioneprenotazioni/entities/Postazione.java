package alessiacotini.gestioneprenotazioni.entities;

import alessiacotini.gestioneprenotazioni.enums.StatoPostazione;
import alessiacotini.gestioneprenotazioni.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Postazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID posazione_id;

    @Column(name="codice_univoco",unique = true, nullable = false)
    private String codiceUnivoco;

    @Column(name= "stato_postazione")
    @Enumerated(EnumType.STRING)
    private StatoPostazione statoPostazione;

    @Column(name = "descrizione_postazione")
    private String descrizionePostazione;

    @Column(name= "tipo_postazione")
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    @Column(name = "numero_massimo")
    private int numeroMassimo;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

}
