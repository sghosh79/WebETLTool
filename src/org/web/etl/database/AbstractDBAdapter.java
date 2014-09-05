package org.web.etl.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class AbstractDBAdapter {
	
	public static final String databaseURL = "jdbc:oracle:thin:@localhost:1521/xexdb";
	
	public static final String databaseUser = "system";
	
	public static final String databasePW = "admin";
	
	
	public Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(databaseURL, databaseUser, databasePW);
			
			//System.out.println("Connection opened");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return connection;
	}	
	
	public void closeConnection(Connection...connections ){
		for(Connection c : connections){
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeStatements(Statement...statements ){
		for(Statement s : statements){
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	

}
