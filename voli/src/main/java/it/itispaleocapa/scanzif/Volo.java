package it.itispaleocapa.scanzif;
import java.time.*;

public class Volo
{
    private String codice;
    private String aeroportoDiPartenza;
    private String aeroportoDiArrivo;
    private LocalDate dataDelVolo;
    private LocalTime oraDiPartenza;
    private LocalTime oraDiArrivo;
    private int numeroDiPosti;
    private double costoDelVolo;
    
    public Volo(String aeroportoDiPartenza, String aeroportoDiArrivo, LocalDate dataDelVolo, LocalTime localDateTime, LocalTime localDateTime2, int numeroDiPosti, double costoDelVolo) {
        codice = aeroportoDiPartenza.substring(0, 3) + aeroportoDiArrivo.substring(0, 3) + dataDelVolo.getYear() + dataDelVolo.getMonthValue() + dataDelVolo.getDayOfMonth() + localDateTime.getHour() + localDateTime.getMinute() + localDateTime2.getHour() + localDateTime2.getMinute() + numeroDiPosti + costoDelVolo;
        this.aeroportoDiPartenza = aeroportoDiPartenza;
        this.aeroportoDiArrivo = aeroportoDiArrivo;
        this.dataDelVolo = dataDelVolo;
        this.oraDiPartenza = localDateTime;
        this.oraDiArrivo = localDateTime2;
        this.numeroDiPosti = numeroDiPosti;
        this.costoDelVolo = costoDelVolo;
    }

    public String getCodice() {
        return codice;
    }
    public String getAeroportoDiPartenza() {
        return aeroportoDiPartenza;
    }
    public String getAeroportoDiArrivo() {
        return aeroportoDiArrivo;
    }
    public LocalDate getDataDelVolo() {
        return dataDelVolo;
    }
    public LocalTime getOraDiPartenza() {
        return oraDiPartenza;
    }
    public LocalTime getOraDiArrivo() {
        return oraDiArrivo;
    }
    public int getNumeroDiPosti() {
        return numeroDiPosti;
    }
    public double getCostoDelVolo() {
        return costoDelVolo;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
    public void setAeroportoDiPartenza(String aeroportoDiPartenza) {
        this.aeroportoDiPartenza = aeroportoDiPartenza;
    }
    public void setAeroportoDiArrivo(String aeroportoDiArrivo) {
        this.aeroportoDiArrivo = aeroportoDiArrivo;
    }
    public void setDataDelVolo(LocalDate dataDelVolo) {
        this.dataDelVolo = dataDelVolo;
    }
    public void setOraDiPartenza(LocalTime oraDiPartenza) {
        this.oraDiPartenza = oraDiPartenza;
    }
    public void setOraDiArrivo(LocalTime oraDiArrivo) {
        this.oraDiArrivo = oraDiArrivo;
    }
    public void setNumeroDiPosti(int numeroDiPosti) {
        this.numeroDiPosti = numeroDiPosti;
    }
    public void setCostoDelVolo(double costoDelVolo) {
        this.costoDelVolo = costoDelVolo;
    }
}