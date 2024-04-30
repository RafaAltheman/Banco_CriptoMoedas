
package model;

public class Ethereum extends Moedas{
    
    public Ethereum(String nomeMoeda, double taxa1, double taxa2, double quant) {
        super("Bitcoin", 0.01, 0.02, 0);
    }
    
    public void comprarEthereum(double valorCompra, double quantCompra){
        double compra = (valorCompra*quantCompra)*0.01;
        setQuant(getQuant() + quantCompra);
    }
    public void venderEthereum(double valorVenda, double quantVenda){
        double compra = (valorVenda*quantVenda)*0.02;
        setQuant(getQuant() + quantVenda);
    }
    
}
