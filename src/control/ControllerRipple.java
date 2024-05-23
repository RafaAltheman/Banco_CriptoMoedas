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
import view.Ripple;

// Esse controller é responsavel por realizar a ligacao da view do Ripple com a funcao
// do DAO de compra e venda. Para fazer pego os valores do banco de dados somente do usuario logado com a 
// ajuda do resnext e realizo as operacoes.

public class ControllerRipple {
    private Ripple view;
    private Investidor investidor;

    public ControllerRipple(Ripple view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void mostraCot(){
        view.getCot().setText(String.valueOf(investidor.getCarteira().getSaldoRipple().getCotacao()));
    }
    
    public void compraRipple(){
        String valor = view.getRipple().getText();
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
            double saldoReal = res.getDouble("saldoreal");
            double saldoRipple = res.getDouble("saldoripple");
            double saldoBitcoin = res.getDouble("saldobitcoin");
            double saldoEthereum = res.getDouble("saldoethereum");
            double quantCompraRipple = Double.parseDouble(valor); 
            double valorReal = (investidor.getCarteira().getSaldoRipple().getCotacao());
            //System.out.println(investidor.getCarteira().getSaldoRipple().getCotacao());
            double quantReal = (quantCompraRipple*valorReal)*0.01;
            double quant = quantReal + valorReal;
            double total = saldoReal - quant;
            double valor1 = saldoRipple + quantCompraRipple;
            if (total >= 0 && valor1 >=0){
              Date data = new Date();
              dao.atualizarCompraRipple(investidor, total, valor1);
              JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);              
              dao.inserirExtrato(investidor, data, false, quant, valorReal, ("Ripple"), saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
          }else{JOptionPane.showMessageDialog(view, "Compra não realizada! Saldo Insuficiente");}
            }
        }catch (SQLException e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(view, "Falha de conexão: " + e.getMessage());
}
    }
        
    public void vendaRipple() throws SQLException{
        String valor = view.getRipple().getText();
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
            double saldoReal = res.getDouble("saldoreal");
            double saldoRipple = res.getDouble("saldoripple");
            double saldoBitcoin = res.getDouble("saldobitcoin");
            double saldoEthereum = res.getDouble("saldoethereum");
            double quantCompraRipple = Double.parseDouble(valor);
            double valorReal = (investidor.getCarteira().getSaldoRipple().getCotacao()); 
            double quantReal = (quantCompraRipple*valorReal)*0.01;
            double quant = valorReal - quantReal;
            double total = saldoReal + quant;
            double valor1 = saldoRipple - quantCompraRipple;
            if (total >= 0 && valor1 >=0){
                  Date data = new Date();
                  dao.atualizarVendaRipple(investidor, total, valor1);
                  JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
                  dao.inserirExtrato(investidor, data, true, total, valorReal, ("Ripple"), saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
             }else{JOptionPane.showMessageDialog(view, "Venda não efetuada! Saldo insuficiente");
            
            }
    
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
    }
}
