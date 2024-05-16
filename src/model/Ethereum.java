
package model;

import java.util.Random;

public class Ethereum extends Moedas implements Tarifacao{
    
    public Ethereum() {
        super(0.01, 0.02, 0, 15000);
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
