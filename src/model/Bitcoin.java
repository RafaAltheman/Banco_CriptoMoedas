package model;

import java.util.Random;

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