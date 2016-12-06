package ConexaoBD;

import java.sql.Connection;
import java.sql.SQLException;

public class testeConexao {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		connection.close();
	}
}
