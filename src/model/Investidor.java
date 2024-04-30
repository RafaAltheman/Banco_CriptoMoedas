package model;

import java.util.ArrayList;

/**
 *
 * @author unifrcampos
 */
public class Investidor extends Pessoa{
    private ArrayList<Investidor> investidores;

    public Investidor(ArrayList<Investidor> investidores) {
        this.investidores = investidores;
    }

    public Investidor(String nome, String cpf, String senha) {
        Investidor investidor = new Investidor(nome, cpf, senha);
        investidores.add(investidor);
    }
    
    public void CriarCarteira(int indice){
        if (indice >= 0 && indice < investidores.size()){
            investidores.get(indice).CriarCarteira(indice);
        }
        else{
            System.out.println("Esse investidor não existe!");
        }
    }
    
}
