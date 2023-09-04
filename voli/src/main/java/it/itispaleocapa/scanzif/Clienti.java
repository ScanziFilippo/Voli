package it.itispaleocapa.scanzif;
import java.io.*;
import java.time.*;
import java.util.*;

public class Clienti
{
    HashMap<String, Cliente> clienti;
    
    public Clienti()
    {
        clienti = new HashMap<>();
    }
    
    public void aggiungi(Cliente cliente){
        clienti.put(cliente.getCodice(), cliente);
    }
    
    public void rimuovi(Cliente cliente){
        clienti.remove(cliente.getCodice());
    }

    public void setCodice(Cliente cliente, String codice) {
        clienti.get(cliente.getCodice()).setCodice(codice);
    }
    public void setNome(Cliente cliente, String nome) {
        clienti.get(cliente.getCodice()).setNome(nome);
    }
    public void setCognome(Cliente cliente, String cognome) {
        clienti.get(cliente.getCodice()).setCognome(cognome);
    }
    public void setNazioneDiNascita(Cliente cliente, String nazioneDiNascita) {
        clienti.get(cliente.getCodice()).setNazioneDiNascita(nazioneDiNascita);
    }
    public void setCittaDiNascita(Cliente cliente, String cittaDiNascita) {
        clienti.get(cliente.getCodice()).setCittaDiNascita(cittaDiNascita);
    }
    public void setDataDiNascita(Cliente cliente, LocalDate dataDiNascita) {
        clienti.get(cliente.getCodice()).setDataDiNascita(dataDiNascita);
    }

    public Cliente cercaCliente(String codice){
        return clienti.get(codice);
    }
    public LinkedList<Cliente> cercaClienteConNome(String nome){
        LinkedList<Cliente> clientiConNome = new LinkedList<>();
        for(Cliente cliente : clienti.values()){
            if(cliente.getNome().equals(nome)){
                clientiConNome.add(cliente);
            }
        }
        return clientiConNome;
    }
    public LinkedList<Cliente> cercaClienteConCognome(String nome){
        LinkedList<Cliente> clientiConNome = new LinkedList<>();
        for(Cliente cliente : clienti.values()){
            if(cliente.getCognome().equals(nome)){
                clientiConNome.add(cliente);
            }
        }
        return clientiConNome;
    }
    public LinkedList<Cliente> cercaClienteConNazioneDiNascita(String nome){
        LinkedList<Cliente> clientiConNome = new LinkedList<>();
        for(Cliente cliente : clienti.values()){
            if(cliente.getNazioneDiNascita().equals(nome)){
                clientiConNome.add(cliente);
            }
        }
        return clientiConNome;
    }
    public LinkedList<Cliente> cercaClienteConCittaDiNascita(String nome){
        LinkedList<Cliente> clientiConNome = new LinkedList<>();
        for(Cliente cliente : clienti.values()){
            if(cliente.getCittaDiNascita().equals(nome)){
                clientiConNome.add(cliente);
            }
        }
        return clientiConNome;
    }
    public LinkedList<Cliente> cercaClienteConDataDiNascita(LocalDate data){
        LinkedList<Cliente> clientiConNome = new LinkedList<>();
        for(Cliente cliente : clienti.values()){
            if(cliente.getDataDiNascita().equals(data)){
                clientiConNome.add(cliente);
            }
        }
        return clientiConNome;
    }

    public void salvaSuFile(){
        try{
            FileOutputStream file = new FileOutputStream("clienti.txt");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(file));
            for(Map.Entry<String, Cliente> entry : clienti.entrySet()){
                out.write(entry.getValue().getCodice() + " " + entry.getValue().getCognome() + " " + entry.getValue().getNome() + " " + entry.getValue().getNazioneDiNascita() + " " + entry.getValue().getCittaDiNascita() + " " + entry.getValue().getDataDiNascita().getYear() + " " + entry.getValue().getDataDiNascita().getMonthValue() + " " + entry.getValue().getDataDiNascita().getDayOfMonth());
                out.newLine();
            }
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void leggiDaFile() throws ClassNotFoundException{
        clienti.clear();
        try{
            FileInputStream file = new FileInputStream("clienti.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(file));
            String line;
            while((line = in.readLine()) != null){
                String[] splittedLine = line.split(" ");
                clienti.put(splittedLine[0], new Cliente(splittedLine[1], splittedLine[2], splittedLine[3], splittedLine[4], LocalDate.of(Integer.parseInt(splittedLine[5]), Integer.parseInt(splittedLine[6]), Integer.parseInt(splittedLine[7]))));
            }
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public int length(){
        return clienti.size();
    }
}
