
package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pessoa;
import view.Login;
import view.Menu;

public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void loginPessoa() {
        Pessoa pessoa = new Pessoa(null, view.getTxtcpf().getText(), view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(pessoa);
            if(res.next()){
                JOptionPane.showMessageDialog(view,"Login Feito!");
                Menu viewMenu = new Menu();
                viewMenu.setVisible(true);
                view.setVisible(false);
            } else{
                JOptionPane.showMessageDialog(view,"Login não foi efeituado.");
            }    
        } catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
    } 
}
