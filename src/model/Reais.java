package model;

public class Reais extends Moedas{
    private double quant;
     
    public Reais(double taxa1, double taxa2, double quant) {
        super( 0, 0, 0);
        this.quant = quant;
    }

    
//    public void sacarReais(double valorSaque) {
//        if (valorSaque <= quant) {
//            this.quant = this.quant - valorSaque;
//        } else {
//            System.out.println("Não há saldo para o saque!");
//        }
//    }
   
}
