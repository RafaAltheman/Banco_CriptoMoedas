package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Investidor;
import view.Extrato;
import model.Pessoa;

public class ControllerExtrato {
    private Extrato view;
    private Investidor investidor;

    public ControllerExtrato(Extrato view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }

    public void mostrarExtrato() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                String tipo = "+";
                double valor = 0;
                double cotacao = 0;
                String nome_moeda = ("teste");
                double real = res.getDouble("real");
                double bitcoin = res.getDouble("bitcoin");
                double ethereum = res.getDouble("ethereum");
                double ripple = res.getDouble("ripple");
                double id_pessoa = 1;
                ResultSet resultado = dao.inserirExtrato(investidor,tipo,valor, cotacao, nome_moeda, real, bitcoin, ethereum, ripple,id_pessoa);
                System.out.println("resultado: " + resultado);
                view.getTextarea().setText(String.valueOf(resultado));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }}
