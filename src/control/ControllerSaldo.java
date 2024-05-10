//package control;
//
//import DAO.Conexao;
//import DAO.PessoaDAO;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//import model.Investidor;
//import view.Consulta;
//
//public class ControllerSaldo {
//    private Consulta view;
//    private Investidor investidor;
//
//    public ControllerSaldo(Consulta view, Investidor investidor) {
//        this.view = view;
//        this.investidor = investidor;
//    }
//    
//    public void mostrarSaldo(){
//        Conexao conexao = new Conexao();
//        try{
//            Connection conn = conexao.getConnection();
//            PessoaDAO dao = new PessoaDAO(conn);
//            ResultSet res = dao.consultar(investidor);
//            if(res.next()){
//                
//            dao.atualizarDeposito(investidor);
//           JOptionPane.showMessageDialog(view, "Saldo atualizado com sucesso! Novo Saldo: " + saldoFinal);
//            }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(view, "Falha de conexão!" + e);
//        }
//    }
//
//}
//}
