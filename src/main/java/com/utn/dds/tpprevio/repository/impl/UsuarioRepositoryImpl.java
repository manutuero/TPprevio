package com.utn.dds.tpprevio.repository.impl;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utn.dds.tpprevio.domain.Usuario;
import com.utn.dds.tpprevio.repository.UsuarioRepository;

public class UsuarioRepositoryImpl implements UsuarioRepository {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	// este metodo crea una base de datos HSQLDB en modo In Memory
	public void initDatabaseInMemory() {
		try {
			connection = ConnectionManager.getConnection();
			
			String sql = "DROP TABLE usuario IF EXISTS";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
				
			sql = "CREATE TABLE usuario ("
				+ "username VARCHAR(25) PRIMARY KEY,"
				+ "password VARCHAR(8),"
				+ "activo BOOLEAN DEFAULT true)";	
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
				
			sql = "INSERT INTO usuario (username, password, activo) VALUES ('manu','1234',true)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();	
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally { 
			// cierro los recursos en orden inverso al que fueron instanciados.
			// a partir de java 7 son "Autocloseables", por lo que luego no usare el bloque finally.
					try {
						if( resultSet != null ) resultSet.close();
						if( preparedStatement != null ) preparedStatement.close();
						if( connection != null ) connection.close();	
					}catch(Exception ex) {
						ex.printStackTrace();
						throw new RuntimeException(ex);
					}
		}
	}
	
	public Usuario buscarPorId(String username) {	
		Usuario usuario = null;
		String sql = null;
		try {
			// establezco la conexion pidiendosela a la clase utilitaria que creamos "ConnectionManager"
			connection = ConnectionManager.getConnection();
			
			// defino un query (con parametro)
			sql = "SELECT * FROM usuario WHERE username = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,username);
			
			// ejecuto la sentencia preparada y obtengo los resultados en un resultSet
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				usuario = new Usuario(resultSet.getString("username"),
									  resultSet.getString("password"),
									  resultSet.getBoolean("activo"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return usuario;
	}
	
	public void cambiarPassword(String username, String password) {
		try {		
			connection = ConnectionManager.getConnection();
			
			String sql = "UPDATE usuario "
					   + "SET password = ? "
					   + "WHERE username = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, username);
			preparedStatement.executeUpdate();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
