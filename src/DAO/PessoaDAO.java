
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Carteira;
import model.Investidor;
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
    
    public ResultSet confirmar(Pessoa pessoa) throws SQLException {
        String sql = "select * from pessoa where senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }

    public void atualizarDeposito(Pessoa pessoa, Carteira carteira, Investidor investidor)throws SQLException{
        String sql = "update pessoa set saldoReal = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getSaldoReal().getQuant());
        statement.setString(2, pessoa.getSenha());
        statement.execute();
        conn.close();
    }
}
