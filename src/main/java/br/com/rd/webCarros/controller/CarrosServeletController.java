package br.com.rd.webCarros.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rd.webCarros.model.Carros;
import br.com.rd.webCarros.percistences.CarrosDao;


@WebServlet("/CarrosServeletController")
public class CarrosServeletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    CarrosDao carrosDao;
    public CarrosServeletController() {
    	
        super();
      try {
		this.carrosDao = new CarrosDao();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String option = request.getParameter("option");
		
		if (option == null  || option == "") {
					
		}
		switch (option) {
		
		case ("inserirCarro"):
			inserirCarro(request, response);
		break;
		case ("excluirCarros"):
			excluirCarros(request, response);
		break;
		case ("atualizarCarros"):
			atualizarCarros(request, response);
		break;
		case ("listarCat"):
			consultarCarros(request, response);
		break;
		
		default:
			listaCarros(request, response);
		
		
		}
	}

	


	private void inserirCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
		request.getRequestDispatcher("Carros").forward(request, response);
		String modeloBack = request.getParameter("modelo");
		
		
		if (modeloBack != null ) {
				} else if (!modeloBack.equals("")) {
			Carros carro = new Carros ();
			
			try {
				this.carrosDao.inserirCarro(carro);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("CarrosServeletController");
	}
	private void excluirCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
			String idBack = request.getParameter("id");
			int id = Integer.parseInt(idBack);
			
			try {
				Carros carro = null;
				this.carrosDao.excluirCarros(carro);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("CarrosServeletController");
			
		}
		private void atualizarCarros(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idBack = request.getParameter("id");
		String modeloBack = request.getParameter("modelo");
		String anoBack = request.getParameter("ano");
		
		if ((idBack != null) && (modeloBack != null) && (anoBack != null)) {
		
		}else if (!modeloBack.equals ("modelo")) {
			Integer id = Integer.parseInt(idBack);
			Integer ano = Integer.parseInt(anoBack);
			Carros carro = new Carros ();
			carro.setId(id);
			
			try {
				this.carrosDao.atualizarCarros(carro);
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		response.sendRedirect("CarrosServeletController");
		
	}

		private void consultarCarros(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String idBack = request.getParameter("id");
			String modeloBack = request.getParameter("modelo");
			String anoBack = request.getParameter("ano");
			
			if ((idBack != null) && (modeloBack != null) && (anoBack != null)) {
			
			}else if (!modeloBack.equals ("modelo")) {
				Integer id = Integer.parseInt(idBack);
				Integer ano = Integer.parseInt(anoBack);
				Carros carro = new Carros ();
				carro.setId(id);
				
				try {
					this.carrosDao.atualizarCarros(carro);
					
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			}
			response.sendRedirect("CarrosServeletController");
			
		}
		
	private void listaCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("listaCarros", this.carrosDao.consultaCarros());
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Carros").forward(request, response);	
	
		
	}
	} 


