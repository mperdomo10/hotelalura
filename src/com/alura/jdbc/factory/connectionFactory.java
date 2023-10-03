package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class connectionFactory {
	
	public DataSource dataSource;

	public connectionFactory(){
	
		ComboPooledDataSource comboPooledDatasource=new ComboPooledDataSource();
		comboPooledDatasource.setJdbcUrl("jdbc:mysql://localhost/dbhotelalura?useTimeZone=True&serverTimeZone=UTC");
		comboPooledDatasource.setUser("root");
		comboPooledDatasource.setPassword("Julio1231");
		/*return DriverManager.getConnection("jdbc:mysql://localhost/dbhotelalura?useTimeZone=True&serverTimeZone=UTC",
					"root",
					"password");*/
		this.dataSource=comboPooledDatasource;
	}
	
	public Connection recuperarConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
		
}
