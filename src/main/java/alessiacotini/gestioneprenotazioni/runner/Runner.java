package alessiacotini.gestioneprenotazioni.runner;

import alessiacotini.gestioneprenotazioni.entities.Edificio;
import alessiacotini.gestioneprenotazioni.entities.Postazione;
import alessiacotini.gestioneprenotazioni.entities.Prenotazione;
import alessiacotini.gestioneprenotazioni.entities.Utente;
import alessiacotini.gestioneprenotazioni.enums.TipoPostazione;
import alessiacotini.gestioneprenotazioni.exception.NotAvailabilityEx;
import alessiacotini.gestioneprenotazioni.exception.NotFoundException;
import alessiacotini.gestioneprenotazioni.services.EdificioService;
import alessiacotini.gestioneprenotazioni.services.PostazioneService;
import alessiacotini.gestioneprenotazioni.services.PrenotazioneService;
import alessiacotini.gestioneprenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {

        //EDIFICI
        Edificio edificioUno = new Edificio("The Hub", "Via del Corso 88", "Roma");
        Edificio edificioDue = new Edificio("Milano Innovation District", "Via Cristina Belgioioso 171", "Milano");
        Edificio edificioTre = new Edificio("Torino Co-Working Space", "Corso Ferrucci 112", "Torino");
        Edificio edificioQuattro = new Edificio("Napoli Tech Hub", "Via Galileo Ferraris 40", "Napoli");
        Edificio edificioCinque = new Edificio("Bologna Business Center", "Via dell'Indipendenza 4", "Bologna");

        edificioUno = edificioService.save(edificioUno);
        edificioDue = edificioService.save(edificioDue);
        edificioTre = edificioService.save(edificioTre);
        edificioQuattro = edificioService.save(edificioQuattro);
        edificioCinque = edificioService.save(edificioCinque);


        //UTENTI
        Utente utenteUno = new Utente("ale_coti", "Alessia", "Cotini", "3975901877", "al.cot@gmail.com","blablabla");
        Utente utenteDue = new Utente("mario_rossi", "Mario", "Rossi", "3331234567", "mario.rossi@gmail.com", "password123");
        Utente utenteTre = new Utente("anna_v", "Anna", "Verdi", "3398765432", "anna.verdi@hotmail.com", "secure456");
        Utente utenteQuattro = new Utente("luca_b", "Luca", "Bianchi", "3471122334", "luca.bianchi@outlook.com", "mysecret2026");
        Utente utenteCinque = new Utente("giulia_n", "Giulia", "Neri", "3285566778", "giulia.neri@yahoo.com", "pass9876");

        utenteUno = utenteService.save(utenteUno);
        utenteDue = utenteService.save(utenteDue);
        utenteTre = utenteService.save(utenteTre);
        utenteQuattro = utenteService.save(utenteQuattro);
        utenteCinque = utenteService.save(utenteCinque);


        //POSTAZIONI
        Postazione postazioneUno = new Postazione("Porta-27", TipoPostazione.OPENSPACE, 120, edificioUno);
        Postazione postazioneDue = new Postazione("Sala-A-Milano", TipoPostazione.SALA_RIUNIONI, 15, edificioDue);
        Postazione postazioneTre = new Postazione("Desk-Torino-04", TipoPostazione.PRIVATO, 1, edificioTre);
        Postazione postazioneQuattro = new Postazione("Open-Napoli-22", TipoPostazione.OPENSPACE, 50, edificioQuattro);
        Postazione postazioneCinque = new Postazione("Sala-Bologna-Executive", TipoPostazione.SALA_RIUNIONI, 8, edificioCinque);

        postazioneUno = postazioneService.save(postazioneUno);
        postazioneDue = postazioneService.save(postazioneDue);
        postazioneTre = postazioneService.save(postazioneTre);
        postazioneQuattro = postazioneService.save(postazioneQuattro);
        postazioneCinque = postazioneService.save(postazioneCinque);


        //PRENOTAZIONI

        try {
            Prenotazione prenotazioneUno = prenotazioneService.disponibilitaPrenotazione(utenteUno, postazioneUno, LocalDate.of(2026, 11, 3));
            System.out.println("Prenotazione confermata. ID: " + prenotazioneUno.getPrenotazione_id());

            Prenotazione prenotazioneDue = prenotazioneService.disponibilitaPrenotazione(utenteDue, postazioneDue, LocalDate.of(2027, 1, 14));
            System.out.println("Prenotazione confermata. ID: " + prenotazioneDue.getPrenotazione_id());

            Prenotazione prenotazioneTre = prenotazioneService.disponibilitaPrenotazione(utenteTre, postazioneTre, LocalDate.of(2028, 12, 12));
            System.out.println("Prenotazione confermata. ID: " + prenotazioneTre.getPrenotazione_id());

            Prenotazione prenotazioneQuattro = prenotazioneService.disponibilitaPrenotazione(utenteQuattro, postazioneQuattro, LocalDate.of(2026, 2, 27));
            System.out.println("Prenotazione confermata. ID: " + prenotazioneQuattro.getPrenotazione_id());

            Prenotazione prenotazioneCinque = prenotazioneService.disponibilitaPrenotazione(utenteCinque, postazioneCinque, LocalDate.of(2029, 5, 10));
            System.out.println("Prenotazione confermata. ID: " + prenotazioneCinque.getPrenotazione_id());
        } catch (NotAvailabilityEx e) {
            System.out.println("Prenotazione non caricata: " + e.getMessage());
        }

        System.out.println("Database popolato con successo.");


        // TEST CON POSTAZIONE OCCUPATA
        try {
            prenotazioneService.disponibilitaPrenotazione(utenteDue, postazioneUno, LocalDate.of(2026, 11, 3));
            System.out.println("Doppia prenotazione sulla stessa postazione");
        } catch (NotAvailabilityEx e) {
            System.out.println("Errore gestito correttamente : " + e.getMessage());
        }

        // TEST UTENTE OCCUPATO
        try {
            prenotazioneService.disponibilitaPrenotazione(utenteUno, postazioneDue, LocalDate.of(2026, 11, 3));
            System.out.println("Doppia prenotazione per lo stesso utente.");
        } catch (NotAvailabilityEx e) {
            System.out.println("Errore gestito correttamente : " + e.getMessage());
        }

        // TEST ID EDIFICIO
        try {
            Edificio edificio = edificioService.findById(edificioQuattro.getEdificio_id());
            System.out.println("Edificio " + edificio.getName() + " trovato con successo.");
        } catch (NotFoundException e) {
            System.out.println("Errore nella ricerca dell'edificio.");
        }

        // TEST CODICE UNIVOCO POSTAZIONE
        try {
            Postazione postazioneTrovata = postazioneService.findByCodiceUnivoco(postazioneUno.getCodiceUnivoco());
            System.out.println("Postazione con codice '" + postazioneTrovata.getCodiceUnivoco() + "' trovata.");
        } catch (NotFoundException e) {
            System.out.println("Errore nella ricerca codice univoco della postazione.");
        }
    }
}
