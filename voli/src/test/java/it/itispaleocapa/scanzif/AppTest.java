package it.itispaleocapa.scanzif;

import static org.junit.Assert.*;

import java.time.*;
import java.util.*;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void creaCliente() {
        Cliente cliente = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        assertEquals("Filippo", cliente.getNome());
        assertEquals("Scanzi", cliente.getCognome());
        assertEquals("Italia", cliente.getNazioneDiNascita());
        assertEquals("Bergamo", cliente.getCittaDiNascita());
        assertEquals(LocalDate.of(2005, 4, 16), cliente.getDataDiNascita());
        assertEquals("ScaFil2005416ItaBer", cliente.getCodice());
    }
    @Test
    public void modificaCliente(){
        Cliente cliente = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        cliente.setNome("Stefano");
        cliente.setCognome("Volpi");
        assertEquals("Stefano", cliente.getNome());
        assertEquals("Volpi", cliente.getCognome());
    }
    @Test 
    public void creaVolo(){
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        assertEquals("BerRom20239312301430100100.0", volo.getCodice());
        assertEquals("Bergamo", volo.getAeroportoDiPartenza());
        assertEquals("Roma", volo.getAeroportoDiArrivo());
        assertEquals(LocalDate.of(2023, 9, 3), volo.getDataDelVolo());
        assertEquals(LocalTime.of(12, 30), volo.getOraDiPartenza());
        assertEquals(LocalTime.of(14, 30), volo.getOraDiArrivo());
        assertEquals(100, volo.getNumeroDiPosti());
        assertEquals(100.0, volo.getCostoDelVolo(), 0.0);
    }
    @Test
    public void modificaVolo(){
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        volo.setAeroportoDiPartenza("Milano");
        volo.setAeroportoDiArrivo("Torino");
        assertEquals("Milano", volo.getAeroportoDiPartenza());
        assertEquals("Torino", volo.getAeroportoDiArrivo());
    }
    @Test 
    public void creaClienti(){
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        clienti.aggiungi(cliente);
        assertEquals(cliente, clienti.cercaCliente("ScaFil2005416ItaBer"));
    }
    @Test
    public void modificaClienti(){
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        clienti.aggiungi(cliente);
        clienti.setNome(cliente, "Stefano");
        clienti.setCognome(cliente, "Volpi");
        assertEquals("Stefano", clienti.cercaCliente("ScaFil2005416ItaBer").getNome());
        assertEquals("Volpi", clienti.cercaCliente("ScaFil2005416ItaBer").getCognome());
    }
    @Test
    public void rimuoviClienti(){
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        clienti.aggiungi(cliente);
        clienti.rimuovi(cliente);
        assertEquals(null, clienti.cercaCliente("ScaFil2005416ItaBer"));
    }
    @Test
    public void cercaCliente(){
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        clienti.aggiungi(cliente);
        assertEquals(cliente, clienti.cercaCliente("ScaFil2005416ItaBer"));
    }
    @Test
    public void cercaClienteConNome(){
        Clienti clienti = new Clienti();
        Cliente cliente1 = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        Cliente cliente2 = new Cliente("Volpi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        Cliente cliente3 = new Cliente("Volpi", "Stefano", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        clienti.aggiungi(cliente1);
        clienti.aggiungi(cliente2);
        clienti.aggiungi(cliente3);
        assertEquals(2, clienti.cercaClienteConNome("Filippo").size());
    }
    @Test
    public void cercaClienteConCognome(){
        Clienti clienti = new Clienti();
        Cliente cliente1 = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        Cliente cliente2 = new Cliente("Volpi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        Cliente cliente3 = new Cliente("Volpi", "Stefano", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        clienti.aggiungi(cliente1);
        clienti.aggiungi(cliente2);
        clienti.aggiungi(cliente3);
        assertEquals(1, clienti.cercaClienteConCognome("Scanzi").size());
    }
    @Test
    public void cercaClienteConNazioneDiNascita(){
        Clienti clienti = new Clienti();
        Cliente cliente1 = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        Cliente cliente2 = new Cliente("Volpi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        Cliente cliente3 = new Cliente("Volpi", "Stefano", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        clienti.aggiungi(cliente1);
        clienti.aggiungi(cliente2);
        clienti.aggiungi(cliente3);
        assertEquals(3, clienti.cercaClienteConNazioneDiNascita("Italia").size());
    }
    @Test
    public void cercaClienteConCittaDiNascita(){
        Clienti clienti = new Clienti();
        Cliente cliente1 = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        Cliente cliente2 = new Cliente("Volpi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        Cliente cliente3 = new Cliente("Volpi", "Stefano", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        clienti.aggiungi(cliente1);
        clienti.aggiungi(cliente2);
        clienti.aggiungi(cliente3);
        assertEquals(3, clienti.cercaClienteConCittaDiNascita("Bergamo").size());
    }
    @Test
    public void cercaClienteConDataDiNascita(){
        Clienti clienti = new Clienti();
        Cliente cliente1 = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        Cliente cliente2 = new Cliente("Volpi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        Cliente cliente3 = new Cliente("Volpi", "Stefano", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        clienti.aggiungi(cliente1);
        clienti.aggiungi(cliente2);
        clienti.aggiungi(cliente3);
        assertEquals(2, clienti.cercaClienteConDataDiNascita(LocalDate.of(2005, 6, 17)).size());
    }
    @Test
    public void creaVoli(){
        Voli voli = new Voli();
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        voli.aggiungi(volo);
        assertEquals(volo, voli.cercaVolo("BerRom20239312301430100100.0"));
    }
    @Test
    public void modificaVoli(){
        Voli voli = new Voli();
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        voli.aggiungi(volo);
        voli.setAeroportoDiPartenza(volo, "Milano");
        voli.setAeroportoDiArrivo(volo, "Torino");
        assertEquals("Milano", voli.cercaVolo("BerRom20239312301430100100.0").getAeroportoDiPartenza());
        assertEquals("Torino", voli.cercaVolo("BerRom20239312301430100100.0").getAeroportoDiArrivo());
    }
    @Test
    public void rimuoviVoli(){
        Voli voli = new Voli();
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        voli.aggiungi(volo);
        assertEquals(volo, voli.cercaVolo("BerRom20239312301430100100.0"));
        voli.rimuovi(volo);
        assertEquals(null, voli.cercaVolo("BerRom20239312301430100100.0"));
    }
    @Test
    public void cercaVolo(){
        Voli voli = new Voli();
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        voli.aggiungi(volo);
        assertEquals(volo, voli.cercaVolo("BerRom20239312301430100100.0"));
    }
    @Test
    public void cercaVoloConAeroportoDiPartenza(){
        Voli voli = new Voli();
        Volo volo1 = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        Volo volo2 = new Volo("Milano", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        Volo volo3 = new Volo("Torino", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        voli.aggiungi(volo1);
        voli.aggiungi(volo2);
        voli.aggiungi(volo3);
        assertEquals(1, voli.cercaVoloConAeroportoDiPartenza("Bergamo").size());
    }
    @Test
    public void cercaVoloConAeroportoDiArrivo(){
        Voli voli = new Voli();
        Volo volo1 = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        Volo volo2 = new Volo("Milano", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        Volo volo3 = new Volo("Torino", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        voli.aggiungi(volo1);
        voli.aggiungi(volo2);
        voli.aggiungi(volo3);
        assertEquals(3, voli.cercaVoloConAeroportoDiArrivo("Roma").size());
    }
    @Test
    public void cercaVoloConDataDelVolo(){
        Voli voli = new Voli();
        Volo volo1 = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        Volo volo2 = new Volo("Milano", "Roma", LocalDate.of(2023, 9, 4), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        Volo volo3 = new Volo("Torino", "Roma", LocalDate.of(2023, 9, 5), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        voli.aggiungi(volo1);
        voli.aggiungi(volo2);
        voli.aggiungi(volo3);
        assertEquals(1, voli.cercaVoloConDataDelVolo(LocalDate.of(2023, 9, 3)).size());
    }
    @Test
    public void cercaVoloConOraDiPartenza(){
        Voli voli = new Voli();
        Volo volo1 = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 29), LocalTime.of(14, 30), 100, 100.0);
        Volo volo2 = new Volo("Milano", "Roma", LocalDate.of(2023, 9, 4), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        Volo volo3 = new Volo("Torino", "Roma", LocalDate.of(2023, 9, 5), LocalTime.of(12, 31), LocalTime.of(14, 30), 100, 100.0);
        voli.aggiungi(volo1);
        voli.aggiungi(volo2);
        voli.aggiungi(volo3);
        assertEquals(1, voli.cercaVoloConOraDiPartenza(LocalTime.of(12, 30)).size());
    }
    @Test
    public void cercaVoloConOraDiArrivo(){
        Voli voli = new Voli();
        Volo volo1 = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 29), LocalTime.of(14, 29), 100, 100.0);
        Volo volo2 = new Volo("Milano", "Roma", LocalDate.of(2023, 9, 4), LocalTime.of(12, 30), LocalTime.of(14, 30), 100, 100.0);
        Volo volo3 = new Volo("Torino", "Roma", LocalDate.of(2023, 9, 5), LocalTime.of(12, 31), LocalTime.of(14, 31), 100, 100.0);
        voli.aggiungi(volo1);
        voli.aggiungi(volo2);
        voli.aggiungi(volo3);
        assertEquals(1, voli.cercaVoloConOraDiArrivo(LocalTime.of(14, 30)).size());
    }
    @Test
    public void cercaVoloConNumeroDiPosti(){
        Voli voli = new Voli();
        Volo volo1 = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 29), LocalTime.of(14, 29), 100, 100.0);
        Volo volo2 = new Volo("Milano", "Roma", LocalDate.of(2023, 9, 4), LocalTime.of(12, 30), LocalTime.of(14, 30), 200, 100.0);
        Volo volo3 = new Volo("Torino", "Roma", LocalDate.of(2023, 9, 5), LocalTime.of(12, 31), LocalTime.of(14, 31), 300, 100.0);
        voli.aggiungi(volo1);
        voli.aggiungi(volo2);
        voli.aggiungi(volo3);
        assertEquals(1, voli.cercaVoloConNumeroDiPosti(200).size());
    }
    @Test
    public void cercaVoloConCostoDelVolo(){
        Voli voli = new Voli();
        Volo volo1 = new Volo("Bergamo", "Roma", LocalDate.of(2023, 9, 3), LocalTime.of(12, 29), LocalTime.of(14, 29), 100, 100.0);
        Volo volo2 = new Volo("Milano", "Roma", LocalDate.of(2023, 9, 4), LocalTime.of(12, 30), LocalTime.of(14, 30), 200, 200.0);
        Volo volo3 = new Volo("Torino", "Roma", LocalDate.of(2023, 9, 5), LocalTime.of(12, 31), LocalTime.of(14, 31), 300, 300.0);
        voli.aggiungi(volo1);
        voli.aggiungi(volo2);
        voli.aggiungi(volo3);
        assertEquals(1, voli.cercaVoloConCostoDelVolo(200.0).size());
    }
    @Test
    public void salvaEImportaClientiSuFile(){
        Clienti clienti = new Clienti();
        Cliente cliente1 = new Cliente("Scanzi", "Filippo", "Italia", "Bergamo", LocalDate.of(2005, 4, 16));
        clienti.aggiungi(cliente1);
        clienti.salvaSuFile();
        Cliente cliente2 = new Cliente ("Volpi", "Stefano", "Italia", "Bergamo", LocalDate.of(2005, 6, 17));
        clienti.aggiungi(cliente2);
        assertEquals(2, clienti.length());
        try {
            clienti.leggiDaFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(1, clienti.length());
    }
}
