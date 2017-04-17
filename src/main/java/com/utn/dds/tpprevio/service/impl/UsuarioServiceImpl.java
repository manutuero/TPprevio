package com.utn.dds.tpprevio.service.impl;

import com.utn.dds.tpprevio.domain.Usuario;
import com.utn.dds.tpprevio.repository.UsuarioRepository;
import com.utn.dds.tpprevio.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository usuarioRepository;

	// Desacoplo el repository del service. El módulo superior ya no instancia directamente el objeto 
	// UsuarioRepository, sino que éste es pasado como parámetro en el constructor del service.
	// El constructor del service se encarga de inyectar la dependencia, 
	// evitando que esta responsabilidad recaiga sobre la propia clase.
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Boolean iniciarSesion(String username, String password) {
		Boolean ingresa = false;
		Usuario usuario = usuarioRepository.buscarPorId(username);

		// el usuario ingresado no existe.
		if(username == null || username.trim().isEmpty() || usuario == null) {
			ingresa = false;
		} 
		
		// no se ingreso contraseña
		else if (password == null || password.trim().isEmpty())
		{
			ingresa = false;
		}
		
		// ingresa
		else if (username.equals(usuario.getUsername()) && password.equals(usuario.getPassword())) {
			ingresa = true;
		}
		return ingresa;
	}
	
	public String cambiarPassword(String username, String password) {
		String respuesta = null;
		
		if(username == null || username.trim().isEmpty()) {
			respuesta = "Debe ingresar un usuario";
		}
		else if(password == null || password.trim().isEmpty()) {
			respuesta = "Debe ingresar una contraseña.";
		}
		
		usuarioRepository.cambiarPassword(username,password);
		
		return respuesta;
	}
}