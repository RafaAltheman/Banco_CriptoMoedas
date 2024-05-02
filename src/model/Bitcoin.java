
package model;

public class Bitcoin extends Moedas {
    private double quant;
    
    public Bitcoin(double taxa1, double taxa2) {
        super(0.02, 0.03);
        this.quant = 0;
    }
    
    public void CompraBitcoin(double valorComprar, double QuantComprar){
        double transacao = (valorComprar * QuantComprar)* 0.02;
        this.quant = this.quant + QuantComprar;
    }
    
    public void VendaBitcoin(double valorVenda, double QuantVenda){
        double transacao = (valorVenda * QuantVenda)* 0.03;
        this.quant = this.quant + QuantVenda;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }
    
}
