package alessiacotini.gestioneprenotazioni.repositories;

import alessiacotini.gestioneprenotazioni.entities.Postazione;
import alessiacotini.gestioneprenotazioni.entities.Prenotazione;
import alessiacotini.gestioneprenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione , UUID> {

    @Query("SELECT COUNT(p) > 0 FROM Prenotazione p WHERE p.postazione = :postazione AND p.data = :data")
    boolean isPostazioneOccupata(@Param("postazione") Postazione postazione, @Param("data") LocalDate data);

    @Query("SELECT COUNT(p) > 0 FROM Prenotazione p WHERE p.utente = :utente AND p.data = :data")
    boolean isUtenteOccupato(@Param("utente") Utente utente, @Param("data") LocalDate data);


}

