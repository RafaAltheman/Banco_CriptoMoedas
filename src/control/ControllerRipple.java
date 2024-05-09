/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

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
    
    //public void compraRipple(){
//        String valor = view.getRipple().getText();
//        Conexao conexao = new Conexao();
//        try{
//            Connection conn = conexao.getConnection();
//            PessoaDAO dao = new PessoaDAO(conn);
//            ResultSet res = dao.consultar(investidor);
//            if(res.next()){
//            double saldoReal = res.getDouble("saldoreal");
//            double saldoRipple = res.getDouble("saldoripple");
//            double quantCompraRipple = Double.parseDouble(valor); 
//            //double quantReal = (quantCompraRipple*cotacao)*0.01;
//            //double total = quantReal - saldoRipple;
//            dao.atualizarCompraRipple(investidor, total);
//            JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
//            }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(view, "Falha de conexão!");
//        }
//    }
//        
//    public void vendaRipple(){
//        String valor = view.getRipple().getText();
//        Conexao conexao = new Conexao();
//        try{
//            Connection conn = conexao.getConnection();
//            PessoaDAO dao = new PessoaDAO(conn);
//            ResultSet res = dao.consultar(investidor);
//            if(res.next()){
//            double saldoReal = res.getDouble("saldoreal");
//            double saldoRipple = res.getDouble("saldoripple");
//            double quantCompraRipple = Double.parseDouble(valor); 
//            //double quantReal = (quantCompraRipple*cotacao)*0.01;
//            //double total = quantReal - saldoRipple;
//            dao.atualizarVendaRipple(investidor, total);
//            JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
//            }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(view, "Falha de conexão!");
//        }
//    }
}
