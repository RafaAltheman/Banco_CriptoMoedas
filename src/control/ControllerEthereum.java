/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

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
    
    //public void compraEthereum(){
//        String valor = view.getEthereum().getText();
//        Conexao conexao = new Conexao();
//        try{
//            Connection conn = conexao.getConnection();
//            PessoaDAO dao = new PessoaDAO(conn);
//            ResultSet res = dao.consultar(investidor);
//            if(res.next()){
//            double saldoReal = res.getDouble("saldoreal");
//            double saldoEthereum = res.getDouble("saldoethereum");
//            double quantCompraEthereum = Double.parseDouble(valor); 
//            //double quantReal = (quantCompraEthereum*cotacao)*0.01;
//            //double total = quantReal - saldoEthereum;
//            dao.atualizarCompraEthereum(investidor, total);
//            JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
//            }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(view, "Falha de conexão!");
//        }
//    }
//        
//    public void vendaEthereum(){
//        String valor = view.getEthereum().getText();
//        Conexao conexao = new Conexao();
//        try{
//            Connection conn = conexao.getConnection();
//            PessoaDAO dao = new PessoaDAO(conn);
//            ResultSet res = dao.consultar(investidor);
//            if(res.next()){
//            double saldoReal = res.getDouble("saldoreal");
//            double saldoEthereum = res.getDouble("saldoethereum");
//            double quantCompraEthereum = Double.parseDouble(valor); 
//            //double quantReal = (quantCompraEthereum*cotacao)*0.02;
//            //double total = quantReal - saldoEthereum;
//            dao.atualizarVendaEthereum(investidor, total);
//            JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
//            }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(view, "Falha de conexão!");
//        }
//    }
}
