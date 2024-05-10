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
import view.Ethereum;

/**
 *
 * @author rafae
 */
public class ControllerEthereum {
    private Ethereum view;
    private Investidor investidor;

    public ControllerEthereum(Ethereum view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void compraEthereum(){
        String valor = view.getEthereum().getText();
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
            double saldoReal = res.getDouble("saldoreal");
            double saldoEthereum = res.getDouble("saldoethereum");
            double quantCompraEthereum = Double.parseDouble(valor); 
            double valorReal = (investidor.getCarteira().getSaldoEthereum().getCotacao());
            System.out.println(investidor.getCarteira().getSaldoEthereum().getCotacao());
            double quantReal = (quantCompraEthereum*valorReal)*0.01;
            double quant = quantReal + valorReal;
            double total = saldoReal - quant;
            double valor1 = quantCompraEthereum + saldoEthereum;
            if (total >= 0){
              dao.atualizarCompraRipple(investidor, total, valor1);
              JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
          }else{JOptionPane.showMessageDialog(view, "Compra não realizada! Saldo Insuficiente");}
            }
        }catch (SQLException e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(view, "Falha de conexão: " + e.getMessage());
}
    }
        
    public void vendaEthereum() throws SQLException{
        String valor = view.getEthereum().getText();
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
            double saldoReal = res.getDouble("saldoreal");
            double saldoEthereum = res.getDouble("saldoethereum");
            double quantCompraEthereum = Double.parseDouble(valor);
            double valorReal = (investidor.getCarteira().getSaldoEthereum().getCotacao()); 
            double quantReal = (quantCompraEthereum*valorReal)*0.02;
            double quant = valorReal - quantReal;
            double total = saldoReal + quant;
            double valor1 = saldoEthereum - quantCompraEthereum;
            if (total >= 0){
                  dao.atualizarVendaRipple(investidor, total, valor1);
                  JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
             }else{JOptionPane.showMessageDialog(view, "Venda não efetuada! Saldo insuficiente");
            
            }
    
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
    }
}
