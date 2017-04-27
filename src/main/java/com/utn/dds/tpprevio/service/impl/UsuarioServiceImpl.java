package com.utn.dds.tpprevio.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

import com.utn.dds.tpprevio.domain.Usuario;
import com.utn.dds.tpprevio.repository.UsuarioRepository;
import com.utn.dds.tpprevio.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;

	// Desacoplo el repository del service. El módulo superior ya no instancia
	// directamente el objeto
	// UsuarioRepository, sino que éste es pasado como parámetro en el
	// constructor del service.
	// El constructor del service se encarga de inyectar la dependencia,
	// evitando que esta responsabilidad recaiga sobre la propia clase.
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Boolean iniciarSesion(String username, String password) {
		Boolean ingresa = false;
		Usuario usuario = usuarioRepository.buscarPorId(username);

		// el usuario ingresado no existe.
		if (username == null || username.trim().isEmpty() || usuario == null) {
			ingresa = false;
		}

		// no se ingreso contraseña
		else if (password == null || password.trim().isEmpty()) {
			ingresa = false;
		}

		// ingresa
		else if (username.equals(usuario.getUsername()) && password.equals(usuario.getPassword())) {
			ingresa = true;
			generarLog(username, password);
		}
		return ingresa;
	}

	public void cambiarPassword(String username, String password) {
		if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
			/* No modifica */
		} else {
			usuarioRepository.cambiarPassword(username, password);
		}
	}

	public void generarLog(String username, String password) {
		JSONObject jsonObject = new JSONObject();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
		
		jsonObject.put("Fecha", hourdateFormat.format(date));
		jsonObject.put("username", username);
		jsonObject.put("password", password);

		// new try Java from 1.8
		try (FileWriter file = new FileWriter("logger.json", true);) {
			file.write(jsonObject.toJSONString() + "\n");
			file.flush();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}