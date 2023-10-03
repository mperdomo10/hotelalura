package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Reserva;

public class ReservaDAO {
	private Connection connection;

	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	public void guardar(Reserva reserva) {
		try {
			String Sql = "INSERT INTO RESERVAS (fechaentrada,fechasalida,valor,forma_pago) values (?,?,?,?)";
			
			try (PreparedStatement pstm=connection.prepareStatement(Sql,Statement.RETURN_GENERATED_KEYS)){
				pstm.setDate(1,reserva.getFechaentrada());
				pstm.setDate(2,reserva.getFechasalida());
				pstm.setString(3,reserva.getValor());
				pstm.setString(4, reserva.getFormapago());
				
				pstm.executeUpdate();
				
				try (ResultSet rst= pstm.getGeneratedKeys()){
					while (rst.next()) {
						reserva.setId(rst.getInt(1));
					}
					
				}
				
			}
		}
		catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
		
		
		
	}
	
	
	
	public List<Reserva> buscar(){
		List<Reserva> reservas=new ArrayList<Reserva>();
		try {
			String sql = "SELECT id,fechaentrada,fechasalida,valor, "
					+ "forma_pago FROM RESERVAS";
			try (PreparedStatement pstm= connection.prepareStatement(sql)){
				pstm.execute();
				
				transformaResultSetEnReserva(reservas,pstm);
		
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
	}  //fin de buscar()
	
	
	public List<Reserva> buscarId(String id) {
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {

			String sql = "SELECT id, fechaentrada, fechasalida, "
					+ "valor, forma_pago FROM reservas WHERE id = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transformaResultSetEnReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void Eliminar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM reservas WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void ActualizarReserva(Date fechaentrada, Date fechasalida, String valor, String formapago, Integer id) {
		try {
	        final PreparedStatement statement = connection.prepareStatement(
	                "UPDATE RESERVAS SET "
	                + " FECHAENTRADA = ?, "
	                + " FECHASALIDA = ?,"
	                + " VALOR = ?,"
	                + " FORMA_PAGO = ?"
	                + " WHERE ID = ?");

	        try (statement) {
	        	
	            statement.setDate(1, fechaentrada);
	            statement.setDate(2, fechasalida);
	            statement.setString(3, valor);
	            statement.setString(4, formapago);
	            statement.setInt(5, id);
	            statement.execute();

	            
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
		
	}
	
	
private void transformaResultSetEnReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Reserva reserva = new Reserva(rst.getInt(1),rst.getDate(2),rst.getDate(3),rst.getString(4),rst.getString(5));
				
				reservas.add(reserva);
				
			}
			
		}
		
	}


	}


	
	




		

