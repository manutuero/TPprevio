package com.utn.dds.tpprevio;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.utn.dds.tpprevio.repository.UsuarioRepository;
import com.utn.dds.tpprevio.repository.impl.UsuarioRepositoryImpl;

// (se debe tener levantado un MYSQL para probar los test)
public class UsuarioRepositoryImplTest {

	private UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();

	@Test
	public void buscarPorId_conUsernameValido_devuelveUsuario() {
		assertNotNull(usuarioRepository.buscarPorId("manu"));
	}
}
