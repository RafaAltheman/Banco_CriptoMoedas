package model;

import java.util.Random;

// Esse model cria uma classe chamada bitcoin que extende todos os metodos do moedas e 
// implementa uma interface chamada tarifacao que chama a funcao atualizarcotacao.
// Essa funcao sorteia um numero com a bibliotaca java ramdom entre 5% acima ou abaixo da cotacao inicial de 320000.

public class Bitcoin extends Moedas implements Tarifacao{    
    public Bitcoin() {
        super(0.02, 0.03, 0, 320000);
    }
    
    @Override
    public void atualizarCotacao(){
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