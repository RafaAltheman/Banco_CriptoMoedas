package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Investidor;
import view.Extrato;

public class ControllerExtrato {
    private Extrato view;
    private Investidor investidor;

    public ControllerExtrato(Extrato view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void mostrarExtrato(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            //ResultSet res2 = dao.consultarID();
            if(res.next()){
                double id = res.getDouble("id");
                double id_pessoa = res.getDouble("id_pessoa");
                System.out.println(id_pessoa);
                System.out.println("a");
            }   
        }catch (SQLException e){
        }
    }
}
