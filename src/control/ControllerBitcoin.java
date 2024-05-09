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
import java.util.Random;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Bitcoin;

/**
 *
 * @author rafae
 */
public class ControllerBitcoin {
    private Bitcoin view;
    private Investidor investidor;

    public ControllerBitcoin(Bitcoin view, Investidor investidor) {
        System.out.println("investidor:" + investidor);
        this.view = view;
        this.investidor = investidor;
    }
    
    public void compraBitcoin(){
        String valor = view.getBitcoin().getText();
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
            double saldoReal = res.getDouble("saldoreal");
            double saldoBitcoin = res.getDouble("saldobitcoin");
            double quantCompraBitcoin = Double.parseDouble(valor); 
            double valorReal = (investidor.getCarteira().getSaldoBitcoin().atualizarCotacaoBitcoin());
            double quantReal = (quantCompraBitcoin*valorReal)*0.98;
            double total = saldoReal - quantReal;
            double valor1 = quantCompraBitcoin + saldoBitcoin;
            if (total > 0){
              dao.atualizarCompraBitcoin(investidor, total, valor1);
              JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
          }else{JOptionPane.showMessageDialog(view, "Compra não realizada! Saldo Insuficiente");}
            }
        }catch (SQLException e) {
            e.printStackTrace(); // Isso irá imprimir a stack trace do erro no console
            JOptionPane.showMessageDialog(view, "Falha de conexão: " + e.getMessage());
}
    }
        
    public void vendaBitcoin() throws SQLException{
        String valor = view.getBitcoin().getText();
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
            double saldoReal = res.getDouble("saldoreal");
            double saldoBitcoin = res.getDouble("saldobitcoin");
            double quantCompraBitcoin = Double.parseDouble(valor);
            double valorReal = (investidor.getCarteira().getSaldoBitcoin().atualizarCotacaoBitcoin()); 
            double quantReal = (quantCompraBitcoin*valorReal)*0.03;
            double total = saldoBitcoin + quantReal;
            double valor1 = saldoBitcoin - quantCompraBitcoin;
            if (total > 0){
                  dao.atualizarVendaBitcoin(investidor, total, valor1);
                  JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
             }else{JOptionPane.showMessageDialog(view, "Venda não efetuada! Saldo insuficiente");
            
            }
    
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
    }
   
}        

