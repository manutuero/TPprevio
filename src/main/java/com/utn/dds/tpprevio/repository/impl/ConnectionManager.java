package com.utn.dds.tpprevio.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// clase utilitaria para manejar las conexiones a bases de datos usando JDBC
public class ConnectionManager {
	// parametros de la conexion (siguiendo el patron Singleton)
	private static String url = "jdbc:hsqldb:mem:pruebaDb";
	private static String driver = "org.hsqldb.jdbc.JDBCDriver";
	private static String dbUser = "sa";
	private static String dbPass = "";
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName(driver);
			try {
				connection = DriverManager.getConnection(url,dbUser,dbPass);
			}catch(SQLException ex) {
				System.out.println("Failed to create the database connection.");
			}
		}catch(ClassNotFoundException ex) {
			throw new ClassNotFoundException(); 
		}	
		return connection;
	}
	
	// sobrecarga del metodo con parametros
	public static Connection getConnection(String url, String driver) throws ClassNotFoundException {
		try {
			Class.forName(driver);
			try {
				connection = DriverManager.getConnection(url,dbUser,dbPass);
			}catch(SQLException ex) {
				System.out.println("Failed to create the database connection.");
			}
		}catch(ClassNotFoundException ex) {
			throw new ClassNotFoundException();
		}	
		return connection;
	}
}
