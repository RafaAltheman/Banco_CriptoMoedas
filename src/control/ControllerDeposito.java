package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Carteira;
import model.Investidor;
import model.Pessoa;
import view.Deposito;
import model.Carteira;
import view.Saque;

/**
 *
 * @author rafae
 */
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
            double valorDeposito = Double.parseDouble(valor); 
            double saldoFinal = saldoAtual + valorDeposito;
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