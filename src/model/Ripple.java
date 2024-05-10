
package model;

import java.util.Random;

public class Ripple extends Moedas{
    private double quant, cotacao;
    
    public Ripple(double taxa1, double taxa2, double cotacao) {
        super(0.01, 0.01,0, 0);
        this.quant = 0;
        this.cotacao = 3;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
    
    public double atualizarCotacaoRipple(){
        Random rand = new Random();
        double variacao = (rand.nextDouble() - 0.5) * 0.1; 
        cotacao += cotacao * variacao;
        setCotacao(cotacao);
        return cotacao;
    }
    
}
