package com.utn.dds.tpprevio.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// clase utilitaria para manejar las conexiones a bases de datos usando JDBC
public class ConnectionManager {

	// parametros de la conexion a MYSQL para produccion (siguiendo el patron Singleton)
	private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/tpprevio";
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_USER = "root";
	private static final String MYSQL_PASS = "";
	
	public static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName(MYSQL_DRIVER);
			try {
				connection = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASS);
			}catch(SQLException ex) {
				System.out.println("Failed to create the MYSQL database connection.");
			}
		}catch(ClassNotFoundException ex) {
			throw new ClassNotFoundException(); 
		}	
		return connection;
	}
	
	// sobrecarga con parametros
	public static Connection getConnection(String url, String driver) throws ClassNotFoundException {
		try {
			Class.forName(driver);
			try {
				connection = DriverManager.getConnection(url,MYSQL_USER,MYSQL_PASS);
			}catch(SQLException ex) {
				System.out.println("Failed to create the MYSQL database connection.");
			}
		}catch(ClassNotFoundException ex) {
			throw new ClassNotFoundException(); 
		}	
		return connection;
	}
}
