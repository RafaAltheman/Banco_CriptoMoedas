
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pessoa;

public class PessoaDAO {
    private Connection conn;
    
    public PessoaDAO (Connection conn){
        this.conn = conn;
    }
    
    public ResultSet consultar(Pessoa pessoa) throws SQLException{
        String sql = "select * from pessoa where cpf = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getCpf());
        statement.setString(2, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
