package alessiacotini.gestioneprenotazioni.services;

import alessiacotini.gestioneprenotazioni.entities.Edificio;
import alessiacotini.gestioneprenotazioni.entities.Postazione;
import alessiacotini.gestioneprenotazioni.entities.Prenotazione;
import alessiacotini.gestioneprenotazioni.entities.Utente;
import alessiacotini.gestioneprenotazioni.exception.NotAvailabilityEx;
import alessiacotini.gestioneprenotazioni.exception.NotFoundException;
import alessiacotini.gestioneprenotazioni.repositories.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;


    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    //DISPONIBILITA' PRENOTAZIONE con utente e postazione liberi in quella data
    public Prenotazione disponibilitaPrenotazione(Utente utente, Postazione postazione, LocalDate data){
        if (prenotazioneRepository.isPostazioneOccupata(postazione, data)) {
            throw new NotAvailabilityEx("La postazione selezionata è già occupata per quella data.");
        }
        if (prenotazioneRepository.isUtenteOccupato(utente, data)) {
            throw new NotAvailabilityEx("L'utente ha già un'altra prenotazione per questa data.");
        }
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setData(data);
        prenotazione.setPostazione(postazione);
        prenotazione.setUtente(utente);

        return prenotazioneRepository.save(prenotazione);
    }

    //CERCO PER ID
    public Prenotazione findById(UUID prenotazioneId) {
        return prenotazioneRepository.findById(prenotazioneId)
                .orElseThrow(() -> new NotFoundException("Edificio con ID : " + prenotazioneId + " non trovato."));
    }
}



