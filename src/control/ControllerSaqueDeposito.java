/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Carteira;
import model.Investidor;
import model.Pessoa;
import view.Deposito;

/**
 *
 * @author rafae
 */
public class ControllerSaqueDeposito {
    private Deposito view;

    public ControllerSaqueDeposito(Deposito view) {
        this.view = view;
    }

    public void atualizarDeposito(){
        Pessoa pessoa = new Pessoa();
        String valor = view.getDeposito().getText();
        String senha = view.getSenha().getText(); 
        String nome = pessoa.getNome();
        String cpf = pessoa.getCpf();
        Carteira carteira = new Carteira();
        Investidor investidor = new Investidor(nome, cpf, senha);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            dao.atualizarDeposito(pessoa,carteira,investidor);
            JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
    }
}