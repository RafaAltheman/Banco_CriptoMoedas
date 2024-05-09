
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

    public void atualizarDeposito(Investidor investidor,double valor)throws SQLException{
        String sql = "update pessoa set saldoreal = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, investidor.getSenha());
        statement.execute();
        conn.close();
    }
    
    public void atualizarSaque(Investidor investidor,double valor)throws SQLException{
        String sql = "update pessoa set saldoreal = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, investidor.getSenha());
        statement.execute();
        conn.close();
    }
    
    public void atualizarCompraBitcoin(Investidor investidor,double valor, double total)throws SQLException{
        String sql = "update pessoa set saldoreal = ?, saldobitcoin = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setDouble(2, total);
        statement.setString(3, investidor.getSenha());
        statement.execute();
        conn.close();
    }
    
    public void atualizarVendaBitcoin(Investidor investidor,double valor, double total)throws SQLException{
        String sql = "update pessoa set saldoreal = ?,  saldobitcoin = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setDouble(2, total);
        statement.setString(3, investidor.getSenha());
        statement.execute();
        conn.close();
    }
}
