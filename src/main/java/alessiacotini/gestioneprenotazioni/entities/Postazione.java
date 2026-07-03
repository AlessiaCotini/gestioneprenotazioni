package alessiacotini.gestioneprenotazioni.entities;

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

    public Postazione(String descrizionePostazione, TipoPostazione tipoPostazione, int numeroMassimo, Edificio edificio) {
        this.descrizionePostazione = descrizionePostazione;
        this.tipoPostazione = tipoPostazione;
        this.numeroMassimo = numeroMassimo;
        this.edificio = edificio;
        creoCodiceUnivoco();
    }
    @PrePersist
    protected void creoCodiceUnivoco() {
        if (this.codiceUnivoco == null) {
            this.codiceUnivoco = UUID.randomUUID().toString();
        }
    }
}
