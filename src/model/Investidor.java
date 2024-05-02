package model;

/**
 *
 * @author unifrcampos
 */
public class Investidor extends Pessoa{
    private Carteira carteira;

    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    }
    
    public void criacaoDaCarteira(){
        if(carteira == null){
            this.carteira = new Carteira();
            System.out.println("Carteira criada!");
        }else{
            System.out.println("O investidor ja possui uma carteira!");
        }
    }
}