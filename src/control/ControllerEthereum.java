
package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
    
    public void mostraCot(){
        view.getCot().setText(String.valueOf(investidor.getCarteira().getSaldoEthereum().getCotacao()));
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
            double saldoBitcoin = res.getDouble("saldobitcoin");
            double saldoRipple = res.getDouble("saldoripple");
            //double saldoBitcoin = res.getDouble("saldobitcoin");
            double quantCompraEthereum = Double.parseDouble(valor); 
            double valorReal = (investidor.getCarteira().getSaldoEthereum().getCotacao());
            //System.out.println(investidor.getCarteira().getSaldoEthereum().getCotacao());
            double quantReal = (quantCompraEthereum*valorReal)*0.01;
            double quant = quantReal + valorReal;
            double total = saldoReal - quant;
            double valor1 = quantCompraEthereum + saldoEthereum;
            if (total >= 0 && valor1 >=0){
              Date data = new Date();
              dao.atualizarCompraEthereum(investidor, total, valor1);
              JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
              dao.inserirExtrato(investidor, data, false, quant, valorReal, ("Ethereum"), saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
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
            double saldoBitcoin = res.getDouble("saldobitcoin");
            double saldoRipple = res.getDouble("saldoripple");
            double quantCompraEthereum = Double.parseDouble(valor);
            double valorReal = (investidor.getCarteira().getSaldoEthereum().getCotacao()); 
            double quantReal = (quantCompraEthereum*valorReal)*0.02;
            double quant = valorReal - quantReal;
            double total = saldoReal + quant;
            double valor1 = saldoEthereum - quantCompraEthereum;
            if (total >= 0 && valor1 >=0){
                  Date data = new Date();
                  dao.atualizarVendaEthereum(investidor, total, valor1);
                  JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + total);
                  dao.inserirExtrato(investidor, data, true, total, valorReal, ("Ethereum"), saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
             }else{JOptionPane.showMessageDialog(view, "Venda não efetuada! Saldo insuficiente");
            
            }
    
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
    }
}
