package model;

// Na classe carteira, as moedas sao criadas aqui dentro e puxam todos os metodos 
// trazendo os get e set, e tambem declara o saldo que a pessoa vai ter na carteria de cada moeda.

public class Carteira {
    private Bitcoin saldoBitcoin;
    private Ripple saldoRipple;
    private Reais saldoReal;
    private Ethereum saldoEthereum;

    public Carteira(){
        saldoBitcoin = new Bitcoin();
        saldoRipple = new Ripple();
        saldoReal = new Reais();
        saldoEthereum = new Ethereum();
    }

    public Bitcoin getSaldoBitcoin() {
        return saldoBitcoin;
    }

    public void setSaldoBitcoin(Bitcoin saldoBitcoin) {
        this.saldoBitcoin = saldoBitcoin;
    }

    public Ripple getSaldoRipple() {
        return saldoRipple;
    }

    public void setSaldoRipple(Ripple saldoRipple) {
        this.saldoRipple = saldoRipple;
    }

    public Reais getSaldoReal() {
        return saldoReal;
    }

    public void setSaldoReal(Reais saldoReal) {
        this.saldoReal = saldoReal;
    }

    public Ethereum getSaldoEthereum() {
        return saldoEthereum;
    }

    public void setSaldoEthereum(Ethereum saldoEthereum) {
        this.saldoEthereum = saldoEthereum;
    }

    @Override
    public String toString() {
        return "Carteira{" + "saldoBitcoin=" + saldoBitcoin + ", saldoRipple=" + saldoRipple + ", saldoReal=" + saldoReal + ", saldoEthereum=" + saldoEthereum + '}';
    } 
}
