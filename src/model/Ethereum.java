
package model;

public class Ethereum extends Moedas{
    private double quant, cotacao;
    
    public Ethereum(double taxa1, double taxa2, double cotacao) {
        super(0.01, 0.02, 0, 0);
        this.quant = 0;
        this.cotacao = 15000;
    }
    
//    public void CompraEthereum(double valorComprar, double QuantComprar){
//        double transacao = (valorComprar * QuantComprar)* 0.01;
//        this.quant = this.quant + QuantComprar;
//    }
//    
//    public void VendaEthereum(double valorVenda, double QuantVenda){
//        double transacao = (valorVenda * QuantVenda)* 0.02;
//        this.quant = this.quant + QuantVenda;
//    }

    
    
}
