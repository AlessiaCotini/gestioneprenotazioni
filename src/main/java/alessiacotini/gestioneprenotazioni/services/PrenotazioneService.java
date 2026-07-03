package alessiacotini.gestioneprenotazioni.services;

import alessiacotini.gestioneprenotazioni.entities.Postazione;
import alessiacotini.gestioneprenotazioni.entities.Prenotazione;
import alessiacotini.gestioneprenotazioni.entities.Utente;
import alessiacotini.gestioneprenotazioni.exception.NotAvailabilityEx;
import alessiacotini.gestioneprenotazioni.repositories.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;


    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    //DISPONIBILITA' PRENOTAZIONE con utente e postazione liberi in quella data
    public Prenotazione disponibilitaPrenotazione(Utente utente, Postazione postazione, LocalDate data){
        if (prenotazioneRepository.existsByPostazioneAndData(postazione, data)) {
            throw new NotAvailabilityEx("La postazione selezionata è già occupata per quella data.");
        }
        if (prenotazioneRepository.existsByUtenteAndData(utente, data)) {
            throw new NotAvailabilityEx("L'utente ha già un'altra prenotazione per questa data.");
        }
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setData(data);
        prenotazione.setPostazione(postazione);
        prenotazione.setUtente(utente);

        return prenotazioneRepository.save(prenotazione);
    }
}



