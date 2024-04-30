
package model;

public class Bitcoin extends Moedas {

    public Bitcoin(String nomeMoeda, double taxa1, double taxa2, double quant) {
        super("Bitcoin", 0.02, 0.03, 0);
    }
    
    public void comprarBitcoin(double valorCompra, double quantCompra){
        double compra = (valorCompra*quantCompra)*0.02;
        setQuant(getQuant() + quantCompra);
    }
    public void venderBitcoin(double valorVenda, double quantVenda){
        double compra = (valorVenda*quantVenda)*0.03;
        setQuant(getQuant() + quantVenda);
    }
    
}
