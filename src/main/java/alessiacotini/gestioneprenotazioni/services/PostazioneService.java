package alessiacotini.gestioneprenotazioni.services;

import alessiacotini.gestioneprenotazioni.entities.Postazione;
import alessiacotini.gestioneprenotazioni.enums.TipoPostazione;
import alessiacotini.gestioneprenotazioni.exception.NotFoundException;
import alessiacotini.gestioneprenotazioni.repositories.PostazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    //SALVO
    public Postazione save(Postazione postazione){
        return postazioneRepository.save(postazione);
    }

    //CERCO PER CODICE UNIVOCO
    public Postazione findByCodiceUnivoco (String codiceUnivoco){
        try {
            return postazioneRepository.findByCodiceUnivoco(codiceUnivoco);
        } catch (NotFoundException e) {
            throw new NotFoundException("La ricerca non ha prodotto risultati");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // CERCO TUTTE LE POSTAZIONI PER CITTÀ E TIPO
    public List<Postazione> findAllPos(String citta, TipoPostazione tipoPostazione) {
        try {
            List<Postazione> postazioni = postazioneRepository.findByCittaAndTipoPostazione(citta, tipoPostazione);
            if (postazioni.isEmpty()) {
                throw new NotFoundException("Nessuna postazione trovata a " + citta + " di tipo " + tipoPostazione);
            }
            return postazioni;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante il recupero delle postazioni.", e);
        }
    }
}
