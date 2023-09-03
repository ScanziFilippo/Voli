package it.itispaleocapa.scanzif;
import java.time.*;

public class Cliente
{
    String cognome;
    String nome;
    String nazioneDiNascita;
    String cittaDiNascita;
    LocalDate dataDiNascita;
    String codice;
    
    public Cliente(String cognome, String nome, String nazioneDiNascita, String cittaDiNascita, LocalDate dataDiNascita) {
        this.cognome = cognome;
        this.nome = nome;
        this.nazioneDiNascita = nazioneDiNascita;
        this.cittaDiNascita = cittaDiNascita;
        this.dataDiNascita = dataDiNascita;
        codice = cognome.substring(0, 3) + nome.substring(0, 3) + dataDiNascita.getYear() + dataDiNascita.getMonthValue() + dataDiNascita.getDayOfMonth() + nazioneDiNascita.substring(0, 3) + cittaDiNascita.substring(0, 3);
    }

    public String getCognome() {
        return cognome;
    }
    public String getNome() {
        return nome;
    }
    public String getNazioneDiNascita() {
        return nazioneDiNascita;
    }
    public String getCittaDiNascita() {
        return cittaDiNascita;
    }
    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }
    public String getCodice() {
        return codice;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNazioneDiNascita(String nazioneDiNascita) {
        this.nazioneDiNascita = nazioneDiNascita;
    }
    public void setCittaDiNascita(String cittaDiNascita) {
        this.cittaDiNascita = cittaDiNascita;
    }
    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
}
