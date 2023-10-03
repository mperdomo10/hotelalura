package com.alura.jdbc.controller;



import java.sql.Date;
import java.util.List;

import com.alura.jdbc.dao.ReservaDAO;
import com.alura.jdbc.factory.connectionFactory;
import com.alura.jdbc.modelo.Reserva;




public class ReservaController {
	
	 private ReservaDAO reservaDAO;

	    
	    public ReservaController() {
	     
		
	    	connectionFactory factory = new connectionFactory();
	        this.reservaDAO = new ReservaDAO(factory.recuperarConexion());
	    }

	public void guardar(Reserva nuevaReserva) {
		nuevaReserva.setId(null);
		reservaDAO.guardar(nuevaReserva);
	}
	
	public List<Reserva> buscar() {
		return this.reservaDAO.buscar();
	}
	
	public List<Reserva> buscarId(String id){
		return this.reservaDAO.buscarId(id);
	}

	public void ActualizarReserva(Date fechaentrada, Date fechasalida, String valor, String formapago, Integer id) {
		this.reservaDAO.ActualizarReserva(fechaentrada, fechasalida, valor, formapago, id);
		
	}

	public void Eliminar(Integer id) {
		this.reservaDAO.Eliminar(id);
	}
	
	


}
