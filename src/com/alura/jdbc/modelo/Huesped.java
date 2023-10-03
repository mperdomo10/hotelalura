package com.alura.jdbc.modelo;

import java.sql.Date;

public class Huesped {
	 	private Integer Id;
	    private String Nombre;
	    private String Apellido;
	    private Date Fechanacimiento;
	    private String Nacionalidad;
	    private String Telefono;
	    private Integer Idreserva;
	    
		
		public Huesped(String nombre, String apellido, Date fechanacimiento, String nacionalidad, String telefono,
				Integer idreserva) {
			this.Nombre = nombre;
			this.Apellido = apellido;
			this.Fechanacimiento = fechanacimiento;
			this.Nacionalidad = nacionalidad;
			this.Telefono = telefono;
			this.Idreserva = idreserva;
			
			
		}
		
		
		public Huesped(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
				String telefono, Integer idreserva) {
			super();
			Id = id;
			Nombre = nombre;
			Apellido = apellido;
			Fechanacimiento = fechaNacimiento;
			Nacionalidad = nacionalidad;
			Telefono = telefono;
			Idreserva = idreserva;
		}


		public Integer getId() {
			return Id;
		}


		public String getNombre() {
			return Nombre;
		}


		public String getApellido() {
			return Apellido;
		}


		public Date getFechanacimiento() {
			return Fechanacimiento;
		}


		public String getNacionalidad() {
			return Nacionalidad;
		}


		public String getTelefono() {
			return Telefono;
		}


		public Integer getIdreserva() {
			return Idreserva;
		}


		public void setId(Integer id) {
			Id = id;
		}
		
		
	    
	    
	

}
