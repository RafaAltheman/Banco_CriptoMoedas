package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
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
    
//     public int consultarID(Investidor investidor) throws SQLException{
//        ResultSet resUser = this.consultar(investidor);
//        if(!resUser.next()) {
//            return -1;
//        }
//        int id_pessoa = resUser.getInt("id");
//        String sql = "select * from extrato where id_pessoa = ?";
//        
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setInt(1, id_pessoa);
//        statement.execute();
//        return statement.executeUpdate();
//    }
    
    public int consultarID(Investidor investidor) throws SQLException {
        ResultSet resUser = this.consultar(investidor);
        if (!resUser.next()) {
            return -1;
        }
        return resUser.getInt("id");
}

    public ResultSet consultarTransacoesPorID(int idPessoa) throws SQLException {
        String sql = "SELECT * FROM extrato WHERE id_pessoa = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idPessoa);
        return statement.executeQuery();
}
    

    public ResultSet confirmar(Pessoa pessoa) throws SQLException {
        String sql = "select * from pessoa where senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public int inserirExtrato(Investidor investidor,Date data ,boolean tipo, double valor, double cotacao, String nomeMoeda, double real, double bitcoin, double ethereum, double ripple) throws SQLException {
        ResultSet resUser = this.consultar(investidor);
        if(!resUser.next()) {
            return -1;
        }
        int id_pessoa = resUser.getInt("id");
        String sql = "INSERT INTO extrato (data, tipo, valor, cotacao, nome_moeda, real, bitcoin, ethereum, ripple, id_pessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setTimestamp(1, new Timestamp(data.getTime()));
            statement.setBoolean(2, tipo);
            statement.setDouble(3, valor);
            statement.setDouble(4, cotacao);
            statement.setString(5, nomeMoeda);
            statement.setDouble(6, real);
            statement.setDouble(7, bitcoin);
            statement.setDouble(8, ethereum);
            statement.setDouble(9, ripple);
            statement.setInt(10, id_pessoa);
            return statement.executeUpdate();
        }
    }

    public void atualizarDeposito(Investidor investidor,double valor)throws SQLException{
        String sql = "update pessoa set saldoreal = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, investidor.getSenha());
        statement.execute();
        //conn.close();
    }
    
    public void atualizarSaque(Investidor investidor,double valor)throws SQLException{
        String sql = "update pessoa set saldoreal = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, investidor.getSenha());
        statement.execute();
        //conn.close();
    }
    
    public void atualizarCompraBitcoin(Investidor investidor,double valor, double total)throws SQLException{
        String sql = "update pessoa set saldoreal = ?, saldobitcoin = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setDouble(2, total);
        statement.setString(3, investidor.getSenha());
        statement.execute();
        //conn.close();
    }
    
    public void atualizarVendaBitcoin(Investidor investidor,double valor, double total)throws SQLException{
        String sql = "update pessoa set saldoreal = ?,  saldobitcoin = ? where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setDouble(2, total);
        statement.setString(3, investidor.getSenha());
        statement.execute();
        //conn.close();
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
