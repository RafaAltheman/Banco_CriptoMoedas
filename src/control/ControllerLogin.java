
package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import model.Pessoa;
import view.Login;
import view.Menu;

// Esse controller faz o login no banco a partir de um usuario que ja existe no banco de dados.
// se caso o usuario nao exista ele mostra mensagem de erro e tambem se algum dos dados estiver errado.


public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void loginPessoa() {
        Investidor investidor = new Investidor(null, view.getTxtcpf().getText(),
        view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view,"Login Feito!");
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                Menu viewMenu = new Menu(new Investidor(nome, cpf, senha));
                viewMenu.setVisible(true);
                view.setVisible(false);
            } else{
                JOptionPane.showMessageDialog(view,"Login não foi efeituado.");
            }    
        } catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão");
        }
    } 
}
