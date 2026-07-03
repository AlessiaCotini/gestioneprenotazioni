package alessiacotini.gestioneprenotazioni.repositories;

import alessiacotini.gestioneprenotazioni.entities.Postazione;
import alessiacotini.gestioneprenotazioni.entities.Prenotazione;
import alessiacotini.gestioneprenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
   Postazione findByCodiceUnivoco (String codiceUnivoco);

   @Query("SELECT p FROM Postazione p WHERE p.edificio.citta = :citta AND p.tipoPostazione = :tipo")
   List<Postazione> cercaPerCittaETipo(@Param("citta") String citta, @Param("tipo") TipoPostazione tipoPostazione);
}
