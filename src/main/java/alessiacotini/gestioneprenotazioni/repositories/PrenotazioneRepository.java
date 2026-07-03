package alessiacotini.gestioneprenotazioni.repositories;

import alessiacotini.gestioneprenotazioni.entities.Postazione;
import alessiacotini.gestioneprenotazioni.entities.Prenotazione;
import alessiacotini.gestioneprenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione , UUID> {
    // true se esiste già una prenotazione per postazione e data
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);
    // true se utente ha gia prenotato in quella data
    boolean existsByUtenteAndData(Utente utente, LocalDate data);
}
