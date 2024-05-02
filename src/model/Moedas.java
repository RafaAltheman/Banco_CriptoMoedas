
package model;

public class Moedas{
    private double taxa1, taxa2;

    public Moedas() {
    }

    public Moedas(double taxa1, double taxa2) {
        this.taxa1 = taxa1;
        this.taxa2 = taxa2;
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
}