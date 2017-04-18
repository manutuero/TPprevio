package com.utn.dds.tpprevio.repository.impl;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utn.dds.tpprevio.domain.Usuario;
import com.utn.dds.tpprevio.repository.UsuarioRepository;
import com.utn.dds.tpprevio.repository.impl.ConnectionManager;

public class UsuarioRepositoryImpl implements UsuarioRepository {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
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
