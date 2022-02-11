package br.com.rd.webCarros.percistences;

import java.sql.SQLException;
import java.util.List;

import br.com.rd.webCarros.model.Carros;

public interface ICarrosDao {

	public void inserirCarro(Carros carro) throws SQLException;
	public void atualizarCarros(Carros carro) throws SQLException;
	public void excluirCarros(Carros carro) throws SQLException;
	public Carros consultarCarros(Carros carro) throws SQLException;
	public List<Carros>consultaCarros() throws SQLException;
	
}
