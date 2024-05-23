
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


// Conexao com banco de dados postgresql
public class Conexao {
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/crypto",
        "postgres","fei");
        return conexao;
    }
}
