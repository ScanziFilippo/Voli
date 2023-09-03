package it.itispaleocapa.scanzif;
import java.io.*;
import java.time.*;
import java.util.*;

public class Voli
{
    HashMap<String, Volo> voli;
    
    public Voli()
    {
        voli = new HashMap<>();
    }
    
    public void aggiungi(Volo volo){
        voli.put(volo.getCodice(), volo);
    }
    
    public void rimuovi(Volo volo){
        voli.remove(volo.getCodice());
    }
    
    public void setCodice(Volo volo, String codice) {
        voli.get(volo.getCodice()).setCodice(codice);
    }
    public void setAeroportoDiPartenza(Volo volo, String aeroportoDiPartenza) {
        voli.get(volo.getCodice()).setAeroportoDiPartenza(aeroportoDiPartenza);
    }
    public void setAeroportoDiArrivo(Volo volo, String aeroportoDiArrivo) {
        voli.get(volo.getCodice()).setAeroportoDiArrivo(aeroportoDiArrivo);
    }
    public void setDataDelVolo(Volo volo, LocalDate dataDelVolo) {
        voli.get(volo.getCodice()).setDataDelVolo(dataDelVolo);
    }
    public void setOraDiPartenza(Volo volo, LocalTime oraDiPartenza) {
        voli.get(volo.getCodice()).setOraDiPartenza(oraDiPartenza);
    }
    public void setOraDiArrivo(Volo volo, LocalTime oraDiArrivo) {
        voli.get(volo.getCodice()).setOraDiArrivo(oraDiArrivo);
    }
    public void setNumeroDiPosti(Volo volo, int numeroDiPosti) {
        voli.get(volo.getCodice()).setNumeroDiPosti(numeroDiPosti);
    }
    public void setCostoDelVolo(Volo volo, double costoDelVolo) {
        voli.get(volo.getCodice()).setCostoDelVolo(costoDelVolo);
    }

    public Volo cercaVolo(String codice){
        return voli.get(codice);
    }

    public void salvaSuFile(){
        try{
            FileOutputStream file = new FileOutputStream("voli.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(voli);
            out.close();
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void leggiDaFile() throws ClassNotFoundException{
        try{
            FileInputStream file = new FileInputStream("voli.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            voli = (HashMap<String, Volo>) in.readObject();
            in.close();
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
