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

    public void salvaSuFile(){
        try{
            FileOutputStream file = new FileOutputStream("clienti.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(clienti);
            out.close();
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void leggiDaFile() throws ClassNotFoundException{
        try{
            FileInputStream file = new FileInputStream("clienti.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            clienti = (HashMap<String, Cliente>) in.readObject();
            in.close();
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
