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
    
    public ResultSet inserirExtrato(Investidor investidor, String tipo, double valor, double cotacao, String nomeMoeda, double real, double bitcoin, double ethereum, double ripple, double id_pessoa) throws SQLException {
        String sql = "INSERT INTO extrato (data, tipo, valor, cotacao, nome_moeda, real, bitcoin, ethereum, ripple, id_pessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
        statement.setString(2, tipo);
        statement.setDouble(3, valor);
        statement.setDouble(4, cotacao);
        statement.setString(5, nomeMoeda);
        statement.setDouble(6, real);
        statement.setDouble(7, bitcoin);
        statement.setDouble(8, ethereum);
        statement.setDouble(9, ripple);
        statement.setDouble(10, id_pessoa);
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
    
    public void atualizarCompraEthereum(Investidor investidor,double valor, double total)throws SQLException{
        String sql = "update pessoa set saldoreal = ?, saldoethereum = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setDouble(2, total);
        statement.setString(3, investidor.getSenha());
        statement.execute();
        conn.close();
    }
    
    public void atualizarVendaEthereum(Investidor investidor,double valor, double total)throws SQLException{
        String sql = "update pessoa set saldoreal = ?,  saldoethereum = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setDouble(2, total);
        statement.setString(3, investidor.getSenha());
        statement.execute();
        conn.close();
    }
    
    public void atualizarCompraRipple(Investidor investidor,double valor, double total)throws SQLException{
        String sql = "update pessoa set saldoreal = ?, saldoripple = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setDouble(2, total);
        statement.setString(3, investidor.getSenha());
        statement.execute();
        conn.close();
    }
    
    public void atualizarVendaRipple(Investidor investidor,double valor, double total)throws SQLException{
        String sql = "update pessoa set saldoreal = ?,  saldoripple = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setDouble(2, total);
        statement.setString(3, investidor.getSenha());
        statement.execute();
        conn.close();
    }
   
}
