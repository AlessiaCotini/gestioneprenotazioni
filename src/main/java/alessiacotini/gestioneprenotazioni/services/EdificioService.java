package alessiacotini.gestioneprenotazioni.services;

import alessiacotini.gestioneprenotazioni.entities.Edificio;
import alessiacotini.gestioneprenotazioni.entities.Utente;
import alessiacotini.gestioneprenotazioni.exception.NotFoundException;
import alessiacotini.gestioneprenotazioni.repositories.EdificioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EdificioService {
    private final EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }
    //SALVO
    public Edificio save(Edificio edificio){
        return edificioRepository.save(edificio);
    }

    //CERCO PER ID
    public Edificio findById(UUID edificioId) {
        return edificioRepository.findById(edificioId)
                .orElseThrow(() -> new NotFoundException("Edificio con ID : " + edificioId + " non trovato."));
    }

    // CERCO TUTTI
    public List<Edificio> findAllEd() {
        try {
            List<Edificio> edifici = edificioRepository.findAll();
            if (edifici.isEmpty()) {
                throw new NotFoundException("La ricerca non ha prodotto risultati");
            }
            return edifici;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante il recupero degli utenti", e);
        }
    }
}
