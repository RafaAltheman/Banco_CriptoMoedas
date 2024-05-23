package model;

// Na classe Investidor extende a classe pessoa e herda todos os metodos get e set de pessoa.
// Alem disso, a classe da carteira é chamada e a cada vez que é criado um investidor é criada uma carteira para ele
// e os metods get e set dela, ou seja, quando o investidor é criado ele ja vai possuir uma carteira automaticamente.

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