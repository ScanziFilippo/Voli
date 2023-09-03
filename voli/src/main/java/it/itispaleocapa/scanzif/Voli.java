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
    public LinkedList<Volo> cercaVoloConAeroportoDiPartenza(String aeroportoDiPartenza){
        LinkedList<Volo> voliConAeroportoDiPartenza = new LinkedList<>();
        for(Volo volo : voli.values()){
            if(volo.getAeroportoDiPartenza().equals(aeroportoDiPartenza)){
                voliConAeroportoDiPartenza.add(volo);
            }
        }
        return voliConAeroportoDiPartenza;
    }
    public LinkedList<Volo> cercaVoloConAeroportoDiArrivo(String aeroportoDiArrivo){
        LinkedList<Volo> voliConAeroportoDiArrivo = new LinkedList<>();
        for(Volo volo : voli.values()){
            if(volo.getAeroportoDiArrivo().equals(aeroportoDiArrivo)){
                voliConAeroportoDiArrivo.add(volo);
            }
        }
        return voliConAeroportoDiArrivo;
    }
    public LinkedList<Volo> cercaVoloConDataDelVolo(LocalDate dataDelVolo){
        LinkedList<Volo> voliConDataDelVolo = new LinkedList<>();
        for(Volo volo : voli.values()){
            if(volo.getDataDelVolo().equals(dataDelVolo)){
                voliConDataDelVolo.add(volo);
            }
        }
        return voliConDataDelVolo;
    }
    public LinkedList<Volo> cercaVoloConOraDiPartenza(LocalTime oraDiPartenza){
        LinkedList<Volo> voliConOraDiPartenza = new LinkedList<>();
        for(Volo volo : voli.values()){
            if(volo.getOraDiPartenza().equals(oraDiPartenza)){
                voliConOraDiPartenza.add(volo);
            }
        }
        return voliConOraDiPartenza;
    }
    public LinkedList<Volo> cercaVoloConOraDiArrivo(LocalTime oraDiArrivo){
        LinkedList<Volo> voliConOraDiArrivo = new LinkedList<>();
        for(Volo volo : voli.values()){
            if(volo.getOraDiArrivo().equals(oraDiArrivo)){
                voliConOraDiArrivo.add(volo);
            }
        }
        return voliConOraDiArrivo;
    }
    public LinkedList<Volo> cercaVoloConNumeroDiPosti(int numeroDiPosti){
        LinkedList<Volo> voliConNumeroDiPosti = new LinkedList<>();
        for(Volo volo : voli.values()){
            if(volo.getNumeroDiPosti() == numeroDiPosti){
                voliConNumeroDiPosti.add(volo);
            }
        }
        return voliConNumeroDiPosti;
    }
    public LinkedList<Volo> cercaVoloConCostoDelVolo(double costoDelVolo){
        LinkedList<Volo> voliConCostoDelVolo = new LinkedList<>();
        for(Volo volo : voli.values()){
            if(volo.getCostoDelVolo() == costoDelVolo){
                voliConCostoDelVolo.add(volo);
            }
        }
        return voliConCostoDelVolo;
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
