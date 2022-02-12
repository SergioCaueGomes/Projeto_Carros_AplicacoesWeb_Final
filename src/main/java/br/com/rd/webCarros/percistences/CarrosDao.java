package br.com.rd.webCarros.percistences;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import br.com.rd.webCarros.model.Carros;

public class CarrosDao implements ICarrosDao{
	
	private Connection c;
	
	public CarrosDao () throws ClassNotFoundException, SQLException {
		IgenericDao cDao = new GenericDao();
		c = cDao.getConnection();
	}
	

	@Override
	public void inserirCarro(Carros carro) throws SQLException {
		
		String sql = "insert into carros (id, modelo, ano) values (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, carro.getId());
		ps.setString(2, carro.getModelo());
		ps.setInt(3, carro.getAno());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizarCarros(Carros carro) throws SQLException {
		
		String sql = "update carros set modelo = ?, ano = ? where id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, carro.getModelo());
		ps.setInt(2, carro.getAno());
		ps.setInt(3, carro.getId());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluirCarros(Carros carro) throws SQLException {
		String sql = "delete carros where id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, carro.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public Carros consultarCarros(Carros carro) throws SQLException {
		String sql = "select id, modelo, ano from carros where id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, carro.getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			carro.setId(rs.getInt("id"));
			carro.setModelo(rs.getString("modelo"));
			carro.setAno(rs.getInt("ano"));
		}
		rs.close();
		ps.close();
		return carro;
	}

	
		
	

	@Override
	public int proximoId() throws SQLException {
		String sql = "select max(id) + 1 AS proximo_id from carros";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			
			return rs.getInt("proximo_id");
		
		} else {
			
			return 1;
		} 
		
	}

	

}
