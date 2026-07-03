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
    @Column(name = "utente_id")
    private UUID utente_id;

    @Column(name = "username", unique = true)
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

    public Utente(String username, String name, String surname, String numeroTelefono, String email, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.password = password;
    }
}
