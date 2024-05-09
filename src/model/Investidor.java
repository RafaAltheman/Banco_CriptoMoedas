package model;

/**
 *
 * @author unifrcampos
 */
public class Investidor extends Pessoa{
    private Carteira carteira;

    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        carteira = new Carteira();
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    @Override
    public String toString() {
        return "Investidor{" + "carteira=" + carteira + '}' + "Pessoa{" + "nome=" + getNome() + ", cpf=" + getCpf() + ", senha=" + getSenha() + '}';
    }

   
    
    

}