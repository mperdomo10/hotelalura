package com.alura.jdbc.controller;

import java.sql.Date;
import java.util.List;

import com.alura.jdbc.dao.HuespedDAO;

import com.alura.jdbc.factory.connectionFactory;
import com.alura.jdbc.modelo.Huesped;


public class HuespedController {

	 private HuespedDAO huespedDAO;

	    
	    public HuespedController() {
	       	connectionFactory factory = new connectionFactory();
	        this.huespedDAO = new HuespedDAO(factory.recuperarConexion());
	    }
	
	public void guardarh(Huesped registrarHuesped) {
		
		huespedDAO.guardarh(registrarHuesped);
		
	}
	
	public List<Huesped> listarHuespedes() {
		return this.huespedDAO.listarHuespedes();
	}
	
	public List<Huesped> listarHuespedesId(String id) {
		return this.huespedDAO.buscarId(id);
	}


	public void actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer idReserva, Integer id) {
		this.huespedDAO.Actualizar(nombre, apellido, fechaN, nacionalidad, telefono, idReserva, id);
		
	}

	public void Eliminar(Integer id) {
		this.huespedDAO.Eliminar(id);
	}

	
		
	}

