package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Investidor;
import model.Pessoa;
import view.Menu;

// Esse controller cria um JOption pane para pedir a senha para o usuario e todas as funcoes 
// dependem da senha estar correta para o usuario prosseguir, sendo assim, isso aumenta a segurança do banco.

public class ControllerConfirma {
    private PessoaDAO pessoaDAO;
    private Conexao conexao;

    public ControllerConfirma() throws SQLException {
        this.conexao = new Conexao();
        this.pessoaDAO = new PessoaDAO(this.conexao.getConnection());
    }

    public boolean verificarSenha(Investidor investidor, Menu menu) {
        String senha = JOptionPane.showInputDialog(menu, "Confirme sua Senha:");
        try {
            
            ResultSet res = pessoaDAO.consultar(investidor);
            if(res.next()){
                if(res.getString("senha").equals(senha)){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace(); 
            return false;
        }
    }
}
