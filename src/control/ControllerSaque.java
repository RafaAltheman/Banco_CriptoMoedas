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
            dao.atualizarDeposito(investidor, saldoFinal);
            System.out.println(saldoFinal);
            System.out.println(valorDeposito);
            System.out.println(saldoAtual);
            JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + saldoFinal);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
    }
}
