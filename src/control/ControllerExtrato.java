package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;
import model.Investidor;
import view.Extrato;

public class ControllerExtrato {
    private Extrato view;
    private Investidor investidor;

    public ControllerExtrato(Extrato view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }

    public String adicionarTransacao(Date data, boolean tipo, double valor, double cotacao, String nome_moeda, double real, double bitcoin, double ethereum, double ripple, int id_pessoa) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = sdf.format(data);
        String tipoTransacao = tipo ? "+" : "-";
        return String.format("Data: %s, Tipo: %s, Valor: %.2f, Cotação: %.2f, Moeda: %s, Real: %.2f, Bitcoin: %.2f, Ethereum: %.2f, Ripple: %.2f, ID Pessoa: %d",
            dataFormatada, tipoTransacao, valor, cotacao, nome_moeda, real, bitcoin, ethereum, ripple, id_pessoa);
    }

    public void mostrarExtrato() {
        Conexao conexao = new Conexao();
        Connection conn = null;
        ResultSet resTransacoes = null;
        StringBuilder extrato = new StringBuilder();
        try {
            conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            int idPessoa = dao.consultarID(investidor);
            resTransacoes = dao.consultarTransacoesPorID(idPessoa);
            while (resTransacoes.next()) {
                Date data = resTransacoes.getTimestamp("data"); 
                boolean tipo = resTransacoes.getBoolean("tipo");
                double valor = resTransacoes.getDouble("valor");
                double cotacao = resTransacoes.getDouble("cotacao");
                String nome_moeda = resTransacoes.getString("nome_moeda");
                double real = resTransacoes.getDouble("real");
                double bitcoin = resTransacoes.getDouble("bitcoin");
                double ethereum = resTransacoes.getDouble("ethereum");
                double ripple = resTransacoes.getDouble("ripple");
                int id_pessoa = resTransacoes.getInt("id_pessoa");
                
                extrato.append(this.adicionarTransacao(data, tipo, valor, cotacao, nome_moeda, real, bitcoin, ethereum, ripple, id_pessoa))
                       .append("\n");
            }
            JTextArea textArea = view.getTextarea();
            textArea.setText(extrato.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resTransacoes != null) resTransacoes.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
