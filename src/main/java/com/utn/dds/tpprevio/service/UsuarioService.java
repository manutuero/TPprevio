package com.utn.dds.tpprevio.service;

public interface UsuarioService {
	public String iniciarSesion(String username, String password);
	public String cambiarPassword(String username, String password);
}
