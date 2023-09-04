package it.itispaleocapa.scanzif;
import java.util.*;

public class Prenotazioni
{
    HashMap<String, Prenotazione> prenotazioni;

    public Prenotazioni()
    {
        prenotazioni = new HashMap<>();
    }

    public void aggiungi(Prenotazione prenotazione){
        prenotazioni.put(prenotazione.getCodiceCliente() + prenotazione.getCodiceVolo(), prenotazione);
    }
    public void rimuovi(Prenotazione prenotazione){
        prenotazioni.remove(prenotazione.getCodiceCliente() + prenotazione.getCodiceVolo());
    }
    public void rimuovi(String codiceCliente, String codiceVolo){
        prenotazioni.remove(codiceCliente + codiceVolo);
    }

    public void setBagagli(Prenotazione prenotazione, int bagagli) {
        prenotazioni.get(prenotazione.getCodiceCliente() + prenotazione.getCodiceVolo()).setBagagli(bagagli);
    }
    public void setPesoMassimoComplessivo(Prenotazione prenotazione, double pesoMassimoComplessivo) {
        prenotazioni.get(prenotazione.getCodiceCliente() + prenotazione.getCodiceVolo()).setPesoMassimoComplessivo(pesoMassimoComplessivo);
    }

    public Prenotazione cercaPrenotazione(String codiceCliente, String codiceVolo){
        return prenotazioni.get(codiceCliente + codiceVolo);
    }
    public LinkedList<Prenotazione> cercaPrenotazioneConCodiceCliente(String codiceCliente){
        LinkedList<Prenotazione> prenotazioniConCodiceCliente = new LinkedList<>();
        for(Prenotazione prenotazione : prenotazioni.values()){
            if(prenotazione.getCodiceCliente().equals(codiceCliente)){
                prenotazioniConCodiceCliente.add(prenotazione);
            }
        }
        return prenotazioniConCodiceCliente;
    }
    public LinkedList<Prenotazione> cercaPrenotazioneConCodiceVolo(String codiceVolo){
        LinkedList<Prenotazione> prenotazioniConCodiceVolo = new LinkedList<>();
        for(Prenotazione prenotazione : prenotazioni.values()){
            if(prenotazione.getCodiceVolo().equals(codiceVolo)){
                prenotazioniConCodiceVolo.add(prenotazione);
            }
        }
        return prenotazioniConCodiceVolo;
    }
}
