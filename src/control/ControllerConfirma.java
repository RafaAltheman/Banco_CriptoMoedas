package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Pessoa;
import view.Menu;

public class ControllerConfirma {
    private PessoaDAO pessoaDAO;
    private Conexao conexao;

    public ControllerConfirma() throws SQLException {
        this.conexao = new Conexao();
        this.pessoaDAO = new PessoaDAO(this.conexao.getConnection());
    }

    public boolean verificarSenha(Pessoa pessoa, Menu menu) {
        String senha = JOptionPane.showInputDialog(menu, "Confirme sua Senha:");
        try {
            // Obter a senha armazenada no banco de dados
            ResultSet res = pessoaDAO.consultar(pessoa);
            if(res.next()){
                if(res.getString("senha").equals(senha)){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace(); // Trate adequadamente a exceção
            return false;
        }
    }
}
