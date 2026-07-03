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
import java.util.List;
import java.util.UUID;

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

        //PER RENDERE DINAMICI GLI ID
        UUID idPrenotazioneUno = null;
        UUID idPrenotazioneDue = null;
        UUID idPrenotazioneTre = null;
        UUID idPrenotazioneQuattro = null;
        UUID idPrenotazioneCinque = null;

        //EDIFICI
        Edificio edificioUno = new Edificio("The Hub", "Via del Corso 88", "Roma");
        Edificio edificioDue = new Edificio("Milano Innovation District", "Via Cristina Belgioioso 171", "Milano");
        Edificio edificioTre = new Edificio("Torino Co-Working Space", "Corso Ferrucci 112", "Torino");
        Edificio edificioQuattro = new Edificio("Napoli Tech Hub", "Via Galileo Ferraris 40", "Napoli");
        Edificio edificioCinque = new Edificio("Bologna Business Center", "Via dell'Indipendenza 4", "Bologna");

//        edificioUno = edificioService.save(edificioUno);
//        edificioDue = edificioService.save(edificioDue);
//        edificioTre = edificioService.save(edificioTre);
//        edificioQuattro = edificioService.save(edificioQuattro);
//        edificioCinque = edificioService.save(edificioCinque);


        //UTENTI
        Utente utenteUno = new Utente("ale_coti", "Alessia", "Cotini", "3975901877", "al.cot@gmail.com","blablabla");
        Utente utenteDue = new Utente("mario_rossi", "Mario", "Rossi", "3331234567", "mario.rossi@gmail.com", "password123");
        Utente utenteTre = new Utente("anna_v", "Anna", "Verdi", "3398765432", "anna.verdi@hotmail.com", "secure456");
        Utente utenteQuattro = new Utente("luca_b", "Luca", "Bianchi", "3471122334", "luca.bianchi@outlook.com", "mysecret2026");
        Utente utenteCinque = new Utente("giulia_n", "Giulia", "Neri", "3285566778", "giulia.neri@yahoo.com", "pass9876");

//        utenteUno = utenteService.save(utenteUno);
//        utenteDue = utenteService.save(utenteDue);
//        utenteTre = utenteService.save(utenteTre);
//        utenteQuattro = utenteService.save(utenteQuattro);
//        utenteCinque = utenteService.save(utenteCinque);


        //POSTAZIONI
        Postazione postazioneUno = new Postazione("Porta-27", TipoPostazione.OPENSPACE, 120, edificioUno);
        Postazione postazioneDue = new Postazione("Sala-A-Milano", TipoPostazione.SALA_RIUNIONI, 15, edificioDue);
        Postazione postazioneTre = new Postazione("Desk-Torino-04", TipoPostazione.PRIVATO, 1, edificioTre);
        Postazione postazioneQuattro = new Postazione("Open-Napoli-22", TipoPostazione.OPENSPACE, 50, edificioQuattro);
        Postazione postazioneCinque = new Postazione("Sala-Bologna-Executive", TipoPostazione.SALA_RIUNIONI, 8, edificioCinque);
//
//        postazioneUno = postazioneService.save(postazioneUno);
//        postazioneDue = postazioneService.save(postazioneDue);
//        postazioneTre = postazioneService.save(postazioneTre);
//        postazioneQuattro = postazioneService.save(postazioneQuattro);
//        postazioneCinque = postazioneService.save(postazioneCinque);


        //RECUPERO DAL DB

        edificioUno = edificioService.findById(UUID.fromString("08a82c11-8805-4eb0-b875-9aa1780db096"));
        edificioDue = edificioService.findById(UUID.fromString("6bcd948a-51af-46e1-b816-49ed8a280b4f"));
        edificioTre = edificioService.findById(UUID.fromString("a46104b7-34fe-4f26-969f-02a121a909a1"));
        edificioQuattro = edificioService.findById(UUID.fromString("bf715d00-f58c-4907-8907-7fb337b3d3d5"));
        edificioCinque = edificioService.findById(UUID.fromString("f1d0b6f3-89eb-42a6-9f44-732b7ca2ebcf"));

        postazioneUno = postazioneService.findByCodiceUnivoco("e9bcc3e7-7cee-40a4-99e0-3278b25f6923");
        postazioneDue = postazioneService.findByCodiceUnivoco("e1d1932a-6734-4f52-8c81-e15ce757b11e");
        postazioneTre = postazioneService.findByCodiceUnivoco("a7e41854-4fb7-48e9-8250-4a6fdde1c7a3");
        postazioneQuattro = postazioneService.findByCodiceUnivoco("cb01cc1f-77b8-4ba0-8a55-e7b2b876af8c");
        postazioneCinque = postazioneService.findByCodiceUnivoco("29b19855-4811-49d4-a544-401c24b9a733");

        utenteUno = utenteService.findById(UUID.fromString("18801cf7-5b03-47b2-becc-02f3bcc10d57"));
        utenteDue = utenteService.findById(UUID.fromString("27768eb8-88d2-473c-8df1-931011c14018"));
        utenteTre = utenteService.findById(UUID.fromString("6f8c6a4a-37db-40b7-af5f-85a6e57a9984"));
        utenteQuattro = utenteService.findById(UUID.fromString("894d7680-6c64-4663-a761-d6f22660fc55"));
        utenteCinque = utenteService.findById(UUID.fromString("a8df5fd2-09bc-42b5-baae-d4a6079124e3"));

        try {
            Prenotazione p1 = prenotazioneService.disponibilitaPrenotazione(utenteUno, postazioneUno, LocalDate.of(2026, 11, 3));
            idPrenotazioneUno = p1.getPrenotazione_id();
            System.out.println("Prenotazione 1 confermata. ID: " + idPrenotazioneUno);

            Prenotazione p2 = prenotazioneService.disponibilitaPrenotazione(utenteDue, postazioneDue, LocalDate.of(2027, 1, 14));
            idPrenotazioneDue = p2.getPrenotazione_id();
            System.out.println("Prenotazione 2 confermata. ID: " + idPrenotazioneDue);

            Prenotazione p3 = prenotazioneService.disponibilitaPrenotazione(utenteTre, postazioneTre, LocalDate.of(2028, 12, 12));
            idPrenotazioneTre = p3.getPrenotazione_id();
            System.out.println("Prenotazione 3 confermata. ID: " + idPrenotazioneTre);

            Prenotazione p4 = prenotazioneService.disponibilitaPrenotazione(utenteQuattro, postazioneQuattro, LocalDate.of(2026, 2, 27));
            idPrenotazioneQuattro = p4.getPrenotazione_id();
            System.out.println("Prenotazione 4 confermata. ID: " + idPrenotazioneQuattro);

            Prenotazione p5 = prenotazioneService.disponibilitaPrenotazione(utenteCinque, postazioneCinque, LocalDate.of(2029, 5, 10));
            idPrenotazioneCinque = p5.getPrenotazione_id();
            System.out.println("Prenotazione 5 confermata. ID: " + idPrenotazioneCinque);
        } catch (NotAvailabilityEx e) {
            System.out.println("Prenotazione non caricata: " + e.getMessage());
        }


        //LETTURA DINAMICA TRAMITE ID
        if (idPrenotazioneUno != null) {
            Prenotazione prenotazioneUno = prenotazioneService.findById(idPrenotazioneUno);
            System.out.println("Letta prenotazioneUno con successo. ID: " + prenotazioneUno.getPrenotazione_id());
        }
        if (idPrenotazioneDue != null) { Prenotazione prenotazioneDue = prenotazioneService.findById(idPrenotazioneDue); }
        if (idPrenotazioneTre != null) { Prenotazione prenotazioneTre = prenotazioneService.findById(idPrenotazioneTre); }
        if (idPrenotazioneQuattro != null) { Prenotazione prenotazioneQuattro = prenotazioneService.findById(idPrenotazioneQuattro); }
        if (idPrenotazioneCinque != null) { Prenotazione prenotazioneCinque = prenotazioneService.findById(idPrenotazioneCinque); }

        System.out.println("Database popolato con successo.");

        //METODI DISPONIBILI

        //EDIFICIO : SALVO - CERCO PER ID - CERCO TUTTI
        //save(Edificio edificio) - findById(UUID edificioId) - findAllEd()

        //POSTAZIONE: SALVO - CERCO PER CODICE UNIVOCO - CERCO TUTTI
        //save(Postazione postazione) - findByCodiceUnivoco (String codiceUnivoco) - findAllPos()

        //PRENOTAZIONE: DISPONIBILITA' PRENOTAZIONE - CERCO PER ID
        //disponibilitaPrenotazione(Utente utente, Postazione postazione, LocalDate data)

        //UTENTE: SALVO - CERCO PER ID - CERCO PER NOME - CERCO PER PARTE DEL NOME - CERCO TUTTI
        //save(Utente utente) - findById (UUID utente_id) - findAllUsers() - findByName (String name) - findByNameContainingIgnoreCase (String contenuto_nome)

        //CERCO UTENTE PER PARTE DEL NOME
        try {
            List<Utente> cercati = utenteService.findByNameContainingIgnoreCase("R");
            System.out.println("Gli utenti trovati sono : "+ cercati);
        }catch (NotFoundException e) {
            throw new NotFoundException("Non ci sono utenti corrispondenti ai risultati di ricerca.");
        }

        //TEST CERCA TUTTI
        try{
            List<Edificio> edifici = edificioService.findAllEd();
            System.out.println("Gli edifici trovati sono : " + edifici);
        } catch (NotFoundException e) {
            throw new NotFoundException("Non ci sono Edifici caricati.");
        }

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

