package com.utn.dds.tpprevio.repository.impl;

import com.utn.dds.tpprevio.repository.CountryRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

public class CountryRespositoryImpl implements CountryRepository {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public void agregarPais(String codigo_pais,String nombre_pais){
		String sql = null;
		
		try {
			// establezco la conexion pidiendosela a la clase utilitaria que creamos "ConnectionManager"
			connection = ConnectionManager.getConnection();
			
			sql = "INSERT INTO pais (codigo_pais,nombre_pais) VALUES (?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,codigo_pais);
			preparedStatement.setString(2,nombre_pais);
			preparedStatement.executeUpdate();	
		}catch(Exception ex){System.out.println("no se conecto en agregar pais");
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	public String buscarPaisPorId(String idPais){
		try{
		connection = ConnectionManager.getConnection();
		
		String sql="SELECT nombre_pais FROM pais WHERE codigo_pais = ?";
		String nombre="";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,idPais);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){	
		nombre= resultSet.getString("nombre_Pais");
		}
		return nombre;
		}catch(Exception ex){System.out.println("no se conecto en bscar pais");
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
