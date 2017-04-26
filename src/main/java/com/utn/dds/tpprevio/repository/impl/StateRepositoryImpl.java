package com.utn.dds.tpprevio.repository.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.utn.dds.tpprevio.domain.State;
import com.utn.dds.tpprevio.repository.StateRepository;

public class StateRepositoryImpl implements StateRepository {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void agregar(String codigo_state, String nombre_state,String fk_state) {
		String sql = null;
		try {
			// establezco la conexion pidiendosela a la clase utilitaria que
			// creamos "ConnectionManager"
			connection = ConnectionManager.getConnection();

			sql = "INSERT INTO state (codigo_state,nombre_state,fk_country) VALUES (?,?,?)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, codigo_state);
			preparedStatement.setString(2, nombre_state);
			preparedStatement.setString(3, fk_state);
			preparedStatement.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	public State buscarPorId(String idState) {
		State state = null;
		try {
			connection = ConnectionManager.getConnection();

			String sql = "SELECT nombre_state FROM state WHERE codigo_state = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, idState);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				state = new State(idState, resultSet.getString("nombre_state"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return state;
	}	
}
