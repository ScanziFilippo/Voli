package it.itispaleocapa.scanzif;

import java.time.LocalDate;

public class App 
{
    public static void main( String[] args )
    {
        Clienti clienti = new Clienti();
        Cliente cliente1 = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        clienti.aggiungi(cliente1);
        clienti.salvaSuFile();
        System.out.println(clienti.length());
        Cliente cliente2 = new Cliente ("Volpi", "Stefano", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        clienti.aggiungi(cliente2);
        System.out.println(clienti.length());
        try {
            clienti.leggiDaFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clienti.length());
    }
}
