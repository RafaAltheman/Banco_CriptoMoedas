
package model;

import java.util.Random;

public class Ripple extends Moedas implements Tarifacao{
    public Ripple() {
        super(0.01, 0.01,0, 2.7);
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
