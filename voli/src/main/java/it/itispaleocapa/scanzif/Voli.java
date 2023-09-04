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
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(file));
            for(Map.Entry<String, Volo> entry : voli.entrySet()){
                out.write(entry.getValue().getCodice() + " " + entry.getValue().getAeroportoDiPartenza() + " " + entry.getValue().getAeroportoDiArrivo() + " " + entry.getValue().getDataDelVolo().getYear() + " " + entry.getValue().getDataDelVolo().getMonthValue() + " " + entry.getValue().getDataDelVolo().getDayOfMonth() + " " + entry.getValue().getOraDiPartenza().getHour() + " " + entry.getValue().getOraDiPartenza().getMinute() + " " + entry.getValue().getOraDiArrivo().getHour() + " " + entry.getValue().getOraDiArrivo().getMinute() + " " + entry.getValue().getNumeroDiPosti() + " " + entry.getValue().getCostoDelVolo());
                out.newLine();
            }
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void leggiDaFile() throws ClassNotFoundException{
        voli.clear();
        try{
            FileInputStream file = new FileInputStream("voli.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(file));
            String line;
            while((line = in.readLine()) != null){
                String[] lineSplit = line.split(" ");
                Volo volo = new Volo(lineSplit[1], lineSplit[2], LocalDate.of(Integer.parseInt(lineSplit[3]), Integer.parseInt(lineSplit[4]), Integer.parseInt(lineSplit[5])), LocalTime.of(Integer.parseInt(lineSplit[6]), Integer.parseInt(lineSplit[7])), LocalTime.of(Integer.parseInt(lineSplit[8]), Integer.parseInt(lineSplit[9])), Integer.parseInt(lineSplit[10]), Double.parseDouble(lineSplit[11]));
                voli.put(lineSplit[0], volo);
            }
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public int length(){
        return voli.size();
    }
}
