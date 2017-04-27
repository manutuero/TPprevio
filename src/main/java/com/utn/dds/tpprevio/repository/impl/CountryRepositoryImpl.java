package com.utn.dds.tpprevio.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utn.dds.tpprevio.domain.Country;
import com.utn.dds.tpprevio.repository.CountryRepository;

public class CountryRepositoryImpl implements CountryRepository {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void agregar(String codigo_pais, String nombre_pais) {
		String sql = null;
		try {
			// establezco la conexion pidiendosela a la clase utilitaria que
			// creamos "ConnectionManager"
			connection = ConnectionManager.getConnection();

			//System.out.println("ENTRO POR COUNTRY");
			
			sql = "INSERT INTO country (codigo_country,nombre_country) VALUES (?,?)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, codigo_pais);
			preparedStatement.setString(2, nombre_pais);
			preparedStatement.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {try {connection.close();}catch (SQLException sq){}}
	}

	public Country buscarPorId(String idPais) {
		Country country = null;
		try {
			connection = ConnectionManager.getConnection();

			String sql = "SELECT nombre_country FROM country WHERE codigo_country = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, idPais);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				country = new Country(idPais, resultSet.getString("nombre_country"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {try {connection.close();}catch (SQLException sq){}}
		return country;
	}
}
