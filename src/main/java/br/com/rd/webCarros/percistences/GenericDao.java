package br.com.rd.webCarros.percistences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao implements IgenericDao {
	
	private Connection c;
	
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("\"jdbc:mysql://localhost:3306/");
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/carros", "root", "root");
			System.out.println("Conexão estabelecida com Banco de Dados.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	
}
