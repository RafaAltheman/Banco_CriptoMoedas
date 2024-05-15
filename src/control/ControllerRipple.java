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
import view.Ripple;

/**
 *
 * @author rafae
 */
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
            double quantCompraRipple = Double.parseDouble(valor); 
            double valorReal = (investidor.getCarteira().getSaldoRipple().getCotacao());
            System.out.println(investidor.getCarteira().getSaldoRipple().getCotacao());
            double quantReal = (quantCompraRipple*valorReal)*0.01;
            double quant = quantReal + valorReal;
            double total = saldoReal - quant;
            double valor1 = saldoRipple + quantCompraRipple;
            if (total >= 0 && valor1 >=0){
              dao.atualizarCompraEthereum(investidor, total, valor1);
              JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
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
            double quantCompraRipple = Double.parseDouble(valor);
            double valorReal = (investidor.getCarteira().getSaldoRipple().getCotacao()); 
            double quantReal = (quantCompraRipple*valorReal)*0.01;
            double quant = valorReal - quantReal;
            double total = saldoReal + quant;
            double valor1 = saldoRipple - quantCompraRipple;
            if (total >= 0 && valor1 >=0){
                  dao.atualizarVendaEthereum(investidor, total, valor1);
                  JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
             }else{JOptionPane.showMessageDialog(view, "Venda não efetuada! Saldo insuficiente");
            
            }
    
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
    }
}
