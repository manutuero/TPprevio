package com.utn.dds.tpprevio.service;

public interface UsuarioService {
	public Boolean iniciarSesion(String username, String password);
	public String cambiarPassword(String username, String password);
}
