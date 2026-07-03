package alessiacotini.gestioneprenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Utente {
    @Id
    @Column(name = "utente_id", unique = true)
    private String username;

    @Column(name = "nome")
    private String name;

    @Column(name = "cognome")
    private String surname;

    @Column(name = "numero")
    private String numeroTelefono;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

}
