package com.alura.jdbc.modelo;

import java.sql.Date;

public class Reserva {
	private Integer id;
    private Date fechaentrada;
    private Date fechasalida;
    private String valor;
    private String formapago;
	//public Object getFechaentrada;

	
    
	public Reserva(Date fechaentrada, Date fechasalida, String valor, String formapago) {
		this.fechaentrada = fechaentrada;
		this.fechasalida = fechasalida;
		this.valor = valor;
		this.formapago = formapago;
	}


	public Reserva(Integer id,Date fechaentrada, Date fechasalida, String valor, String formapago) {
		this.id = id;
		this.fechaentrada = fechaentrada;
		this.fechasalida = fechasalida;
		this.valor = valor;
		this.formapago = formapago;
	}



	public Date getFechaentrada() {
		return fechaentrada;
	}


	public Integer getId() {
		return id;
	}




	public Date getFechasalida() {
		return fechasalida;
	}

	public String getValor() {
		return valor;
	}


	public String getFormapago() {
		return formapago;
	}

    

	public void setId(Integer id) {
		this.id = id;
	}
    
 
}
