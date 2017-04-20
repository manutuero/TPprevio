package com.utn.dds.tpprevio.service;

public interface UsuarioService {
	public Boolean iniciarSesion(String username, String password);
	public void cambiarPassword(String username, String password);
	public void generarLog(String username, String password);
}
