package com.utn.dds.tpprevio.domain;

public class Usuario {

	private String username;
	
	private String password;
	
	private Boolean activo;
	
	public Usuario(){
		
	}
	
	public Usuario(String username, String password, Boolean activo) {
		this.username = username;
		this.password = password;
		this.activo = activo;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
