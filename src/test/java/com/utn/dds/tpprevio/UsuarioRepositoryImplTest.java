package com.utn.dds.tpprevio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.utn.dds.tpprevio.domain.Usuario;
import com.utn.dds.tpprevio.repository.UsuarioRepository;
import com.utn.dds.tpprevio.repository.impl.UsuarioRepositoryImpl;

public class UsuarioRepositoryImplTest {

	private UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();

	@Before
	public void initDatabase() {
		usuarioRepository.initDatabaseInMemory();
	}

	@Test
	public void buscarPorId_conUsernameValido_devuelveUsuario() {
		Usuario usuario = usuarioRepository.buscarPorId("manu");
		assertEquals("manu", usuario.getUsername());
		assertEquals("1234", usuario.getPassword());
		assertEquals(true, usuario.getActivo());
	}
}
