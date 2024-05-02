
package model;

public class Reais extends Moedas{
    private double quant;
     
    public Reais(double taxa1, double taxa2) {
        super( 0 , 0);
        this.quant = 0;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }
    
    public void DepositoReais(double valorDeposito){
        this.quant = this.quant + valorDeposito;
    }
    
    public void sacarReais(double valorSaque) {
        if (valorSaque <= quant) {
            this.quant = this.quant - valorSaque;
        } else {
            System.out.println("Não há saldo para o saque!");
        }
    }
   
}
