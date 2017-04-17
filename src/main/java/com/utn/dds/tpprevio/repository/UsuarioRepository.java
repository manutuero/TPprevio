package com.utn.dds.tpprevio.repository;

import com.utn.dds.tpprevio.domain.Usuario;

public interface UsuarioRepository {
	public Usuario buscarPorId(String username);
	public void cambiarPassword(String username, String password);
}
