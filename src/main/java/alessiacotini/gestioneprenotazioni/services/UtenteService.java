package alessiacotini.gestioneprenotazioni.services;

import alessiacotini.gestioneprenotazioni.entities.Utente;
import alessiacotini.gestioneprenotazioni.exception.NotAvailabilityEx;
import alessiacotini.gestioneprenotazioni.exception.NotFoundException;
import alessiacotini.gestioneprenotazioni.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    //SALVO
    public Utente save(Utente utente){
        return utenteRepository.save(utente);
    }

    //CERCO PER ID
    public Optional<Utente> findById (UUID utente_id){
        try {
            return utenteRepository.findById(utente_id);
        } catch (NotFoundException e) {
            throw new NotFoundException("La ricerca non ha prodotto risultati");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // CERCO TUTTI
    public List<Utente> findAllUsers() {
        try {
            List<Utente> utenti = utenteRepository.findAll();
            if (utenti.isEmpty()) {
                throw new NotFoundException("La ricerca non ha prodotto risultati");
            }
            return utenti;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante il recupero degli utenti", e);
        }
    }

    //CERCO PER NOME
    public List<Utente> findByName (String name){
        try {
            return utenteRepository.findByName(name);
        }catch (NotFoundException ex)
        { throw new NotAvailabilityEx("Utente "+ name +" non trovato");}
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //CERCO PER PARTE DEL NOME
    public List<Utente> findByNameContainingIgnoreCase (String contenuto_nome){
        try{
            return utenteRepository.findByNameContainingIgnoreCase(contenuto_nome);
        }
        catch (NotFoundException ex)
        { throw new NotFoundException("Nessun elemento corrisponde ai criteri di ricerca."); }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
