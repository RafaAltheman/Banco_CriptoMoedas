package model;

// Esse model cria uma classe chamada Reais que extende todos os metodos do moedas e 
// implementa uma interface chamada tarifacao que chama a funcao atualizarcotacao.


public class Reais extends Moedas implements Tarifacao{
    public Reais() {
        super( 0, 0, 0, 0);
    }
}
