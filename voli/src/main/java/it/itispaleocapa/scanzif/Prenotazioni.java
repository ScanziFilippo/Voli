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

    public void setBagagli(Prenotazione prenotazione, int bagagli) {
        prenotazioni.get(prenotazione.getCodiceCliente() + prenotazione.getCodiceVolo()).setBagagli(bagagli);
    }
    public void setPesoMassimoComplessivo(Prenotazione prenotazione, double pesoMassimoComplessivo) {
        prenotazioni.get(prenotazione.getCodiceCliente() + prenotazione.getCodiceVolo()).setPesoMassimoComplessivo(pesoMassimoComplessivo);
    }
}
