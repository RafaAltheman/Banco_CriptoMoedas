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
import javax.swing.JOptionPane;
import model.Investidor;
import view.Saque;

/**
 *
 * @author rafae
 */
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
            double valorDeposito = Double.parseDouble(valor); 
            double saldoFinal = saldoAtual - valorDeposito;
                if (saldoFinal >= 0){
                dao.atualizarDeposito(investidor, saldoFinal);
                JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + saldoFinal);
                }else{
                JOptionPane.showMessageDialog(view, "a operaçao nao foi realizada! Saldo insuficiente " + saldoFinal);
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
    }
}
