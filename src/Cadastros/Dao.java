package Cadastros;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	
	Connection con; //Conexão ao Banco de Dados
	PreparedStatement stmt; //Acessa a tabela
	ResultSet rs; //Consulta a tabela
	CallableStatement call; //Producers e Function
	
	public void open() throws Exception{
		String url = "jdbc:postgresql://localhost:5432/cadastros";
		String user = "postgres";
		String password = "201204";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Erro ao conectar com o banco " + ex);
		}
	}
	
	public void close() throws Exception {
		con.close();
		stmt.close();
	}
}
