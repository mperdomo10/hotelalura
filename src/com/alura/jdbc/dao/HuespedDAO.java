package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Huesped;


public class HuespedDAO {

	private Connection connection;

	public HuespedDAO(Connection connection) {
		this.connection = connection;
	}

	public void guardarh(Huesped registrarHuesped) {
		try {
			String Sql = "INSERT INTO HUESPEDES (nombre,apellido,fechanacimiento,nacionalidad,telefono,id_reserva) values (?,?,?,?,?,?)";
			
			try (PreparedStatement pstm=connection.prepareStatement(Sql,Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1,registrarHuesped.getNombre());
				pstm.setString(2,registrarHuesped.getApellido());
				pstm.setDate(3,registrarHuesped.getFechanacimiento());
				pstm.setString(4, registrarHuesped.getNacionalidad());
				pstm.setString(5, registrarHuesped.getTelefono()); 
				pstm.setInt(6, registrarHuesped.getIdreserva()); 
				
				pstm.executeUpdate();
				
				try (ResultSet rst= pstm.getGeneratedKeys()){
					while (rst.next()) {
						registrarHuesped.setId(rst.getInt(1));
					}
					
				}
				
			}
		}
		catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}
	
	
	public List<Huesped> listarHuespedes() {
		List<Huesped> huesped = new ArrayList<Huesped>();
		try {
			String sql = "SELECT id, nombre, apellido, fechanacimiento, nacionalidad, telefono, id_reserva FROM huespedes";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				transformarResultSetEnHuesped(huesped, pstm);
			}
			return huesped;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huesped> buscarId(String id) {
		List<Huesped> huespedes = new ArrayList<Huesped>();
		try {

			String sql = "SELECT id, nombre, apellido, fechanacimiento, nacionalidad, telefono, id_reserva FROM huespedes WHERE id_reserva = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer idReserva, Integer id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE huespedes SET nombre = ?, apellido = ?, fechanacimiento = ?, nacionalidad = ?, telefono = ?, id_Reserva = ? WHERE id = ?")) {
			stm.setString(1, nombre);
			stm.setString(2, apellido);
			stm.setDate(3, fechaN);
			stm.setString(4, nacionalidad);
			stm.setString(5, telefono);
			stm.setInt(6, idReserva);
			stm.setInt(7, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void Eliminar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM huespedes WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void transformarResultSetEnHuesped(List<Huesped> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Huesped huesped = new Huesped(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));
				reservas.add(huesped);
			}
		}				
	}
	
	
	
	
		
	}


