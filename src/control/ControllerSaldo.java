package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Consulta;

public class ControllerSaldo {
    private Consulta view;
    private Investidor investidor;

    public ControllerSaldo(Consulta view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void mostrarSaldo(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                double saldoReal = res.getDouble("saldoreal");
                double saldoBitcoin = res.getDouble("saldobitcoin");
                double saldoEthereum = res.getDouble("saldoethereum");
                double saldoRipple = res.getDouble("saldoripple");
                view.getReal().setText(String.valueOf(saldoReal));
                view.getBitcoin().setText(String.valueOf(saldoBitcoin));
                view.getEthereum().setText(String.valueOf(saldoEthereum));
                view.getRipple().setText(String.valueOf(saldoRipple));
                view.getNome().setText(investidor.getNome());
                view.getCpf().setText(investidor.getCpf());
            }
        }catch (SQLException e){
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(view, "Falha de conexão: " + e.getMessage());
        }

}
}
