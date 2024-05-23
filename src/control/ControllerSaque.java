/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Saque;

// Esse controller é responsavel por realizar a ligacao da view do saque com a funcao
// do DAO de sacar. Para fazer pego os valores do banco de dados somente do usuario logado com a 
// ajuda do resnext e realizo as operacoes.

public class ControllerSaque {
    private Saque view;
    private Investidor investidor;

    public ControllerSaque(Saque view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void atualizarSaque(){
        String valor = view.getSaque().getText();
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
            double saldoAtual = res.getDouble("saldoreal");
            double saldoBitcoin = res.getDouble("saldobitcoin");
            double saldoEthereum = res.getDouble("saldoethereum");
            double saldoRipple = res.getDouble("saldoripple");
            double valorDeposito = Double.parseDouble(valor); 
            double saldoFinal = saldoAtual - valorDeposito;
            Date data = new Date();
                if (saldoFinal >= 0){
                    dao.atualizarDeposito(investidor, saldoFinal);
                    JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + saldoFinal);
                    dao.inserirExtrato(investidor, data, false, valorDeposito, 0, ("Real"), saldoAtual, saldoBitcoin, saldoEthereum, saldoRipple);
                }else{
                JOptionPane.showMessageDialog(view, "a operaçao nao foi realizada! Saldo insuficiente " + saldoFinal);
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
    }
}
