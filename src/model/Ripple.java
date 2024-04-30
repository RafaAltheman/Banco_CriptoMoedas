
package model;

public class Ripple extends Moedas{
    
    public Ripple(String nomeMoeda, double taxa1, double taxa2, double quant) {
        super("Ripple", 0.01, 0.01, 0);
    }
    
    public void comprarRipple(double valorCompra, double quantCompra){
        double compra = (valorCompra*quantCompra)*0.01;
        setQuant(getQuant() + quantCompra);
    }
    public void venderRipple(double valorVenda, double quantVenda){
        double compra = (valorVenda*quantVenda)*0.01;
        setQuant(getQuant() + quantVenda);
    }
    
}
