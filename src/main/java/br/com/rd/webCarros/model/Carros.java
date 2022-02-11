package br.com.rd.webCarros.model;

public class Carros {
	private int id;
	private String modelo;
	private int ano;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.modelo;
	}
	
	
}
