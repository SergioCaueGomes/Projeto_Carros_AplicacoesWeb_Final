package br.com.rd.webCarros.percistences;

import java.sql.Connection;
import java.sql.SQLException;

public interface IgenericDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException;
	
	
	
}
