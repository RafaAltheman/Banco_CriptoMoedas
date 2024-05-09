
package model;

import java.util.Random;

public class Bitcoin extends Moedas {
    private double quant, cotacao;
    
    public Bitcoin(double taxa1, double taxa2, double cotacao) {
        super(0.02, 0.03, 0, 0);
        this.quant = 0;
        this.cotacao = 320000;
    }
    
    public double atualizarCotacaoBitcoin(){
        Random rand = new Random();
        double variacao = (rand.nextDouble() - 0.5) * 0.1; 
        cotacao += cotacao * variacao;
        return cotacao;
    }
    
    
}
