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
        clienti.aggiungi(cliente1);
        clienti.aggiungi(cliente2);
        assertEquals(2, clienti.cercaClienteConNome("Filippo").size());
    }
}
