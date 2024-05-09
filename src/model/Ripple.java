
package model;

public class Ripple extends Moedas{
    private double quant, cotacao;
    
    public Ripple(double taxa1, double taxa2, double cotacao) {
        super(0.01, 0.01,0, 0);
        this.quant = 0;
        this.cotacao = 3;
    }
    
//    public void CompraRipple(double valorComprar, double QuantComprar){
//        double transacao = (valorComprar * QuantComprar)* 0.01;
//        this.quant = this.quant + QuantComprar;
//    }
//    
//    public void VendaRipple(double valorVenda, double QuantVenda){
//        double transacao = (valorVenda * QuantVenda)* 0.01;
//        this.quant = this.quant + QuantVenda;
//    }
//
//    public double getQuant() {
//        return quant;
//    }
//
//    public void setQuant(double quant) {
//        this.quant = quant;
//    }
}
