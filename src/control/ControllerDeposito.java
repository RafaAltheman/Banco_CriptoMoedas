package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Date;
import model.Carteira;
import model.Investidor;
import model.Pessoa;
import view.Deposito;
import model.Carteira;
import view.Saque;

// Esse controller é responsavel por realizar a ligacao da view do deposito com a funcao
// do DAO de depositar. Para fazer pego os valores do banco de dados somente do usuario logado com a 
// ajuda do resnext e realizo as operacoes.

public class ControllerDeposito {
    private Deposito view;
    private Investidor investidor;

    public ControllerDeposito(Deposito view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }

    public void atualizarDeposito(){
        String valor = view.getDeposito().getText();
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
            double saldoFinal = saldoAtual + valorDeposito;
            Date data = new Date();
            dao.atualizarDeposito(investidor, saldoFinal);
//            System.out.println(saldoFinal);
//            System.out.println(valorDeposito);
//            System.out.println(saldoAtual);
            JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + saldoFinal);
            dao.inserirExtrato(investidor, data, true, valorDeposito, 0, ("Real"), saldoAtual, saldoBitcoin, saldoEthereum, saldoRipple);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!" + e);
        }
    }

}