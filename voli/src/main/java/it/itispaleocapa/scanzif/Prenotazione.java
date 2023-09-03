package it.itispaleocapa.scanzif;
public class Prenotazione
{
    private String codiceCliente;
    private String codiceVolo;
    private int bagagli;
    private double pesoMassimoComplessivo;

    public Prenotazione(String codiceCliente, String codiceVolo, int bagagli, double pesoMassimoComplessivo) {
        this.codiceCliente = codiceCliente;
        this.codiceVolo = codiceVolo;
        this.bagagli = bagagli;
        this.pesoMassimoComplessivo = pesoMassimoComplessivo;
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }
    public String getCodiceVolo() {
        return codiceVolo;
    }
    public int getBagagli() {
        return bagagli;
    }
    public double getPesoMassimoComplessivo() {
        return pesoMassimoComplessivo;
    }

    public void setBagagli(int bagagli) {
        this.bagagli = bagagli;
    }
    public void setPesoMassimoComplessivo(double pesoMassimoComplessivo) {
        this.pesoMassimoComplessivo = pesoMassimoComplessivo;
    }
}
