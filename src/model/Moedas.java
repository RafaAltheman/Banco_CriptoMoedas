
package model;

public class Moedas extends Carteira{
    private String nomeMoeda;
    private double taxa1, taxa2, quant;

    public Moedas() {
    }

    public Moedas(String nomeMoeda, double taxa1, double taxa2, double quant) {
        this.nomeMoeda = nomeMoeda;
        this.taxa1 = taxa1;
        this.taxa2 = taxa2;
        this.quant = quant;
    }

    public String getNomeMoeda() {
        return nomeMoeda;
    }

    public void setNomeMoeda(String nomeMoeda) {
        this.nomeMoeda = nomeMoeda;
    }

    public double getTaxa1() {
        return taxa1;
    }

    public void setTaxa1(double taxa1) {
        this.taxa1 = taxa1;
    }

    public double getTaxa2() {
        return taxa2;
    }

    public void setTaxa2(double taxa2) {
        this.taxa2 = taxa2;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    @Override
    public String toString() {
        return "Moedas{" + "nomeMoeda=" + nomeMoeda + ", taxa1=" + taxa1 + ", taxa2=" + taxa2 + ", quant=" + quant + '}';
    }

    
}
