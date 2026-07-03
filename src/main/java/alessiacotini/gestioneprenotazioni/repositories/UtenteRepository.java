package alessiacotini.gestioneprenotazioni.repositories;

import alessiacotini.gestioneprenotazioni.entities.Prenotazione;
import alessiacotini.gestioneprenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, UUID> {
    List<Utente> findByName(String name);

    List<Utente> findByNameContainingIgnoreCase(String contenutoNome);
}
