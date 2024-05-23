package model;
import java.util.Random;

// Na classe moedas eu declaro as taxas, quantidade de cada uma e a cotacao inicial. Os metodos get e 
// set e a funcao de atualizar cotacao.

public class Moedas{
    private double taxa1, taxa2, quant, cotacao;

    public Moedas() {
    }

    public Moedas(double taxa1, double taxa2, double quant, double cotacao) {
        this.taxa1 = taxa1;
        this.taxa2 = taxa2;
        this.quant = quant;
        this.cotacao = cotacao;
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
    
    public void atualizarCotacao() {
        double cotatual = this.getCotacao();
        Random r = new Random();
        double rand = r.nextDouble() * 0.05 * cotatual;
        boolean randbool = r.nextBoolean();
        if(randbool){
            rand *= -1;
        }
        cotatual += rand;
        this.setCotacao(cotatual);
    }
}
