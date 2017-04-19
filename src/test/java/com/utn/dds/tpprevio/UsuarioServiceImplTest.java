package com.utn.dds.tpprevio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.utn.dds.tpprevio.domain.Usuario;
import com.utn.dds.tpprevio.repository.UsuarioRepository;
import com.utn.dds.tpprevio.repository.impl.UsuarioRepositoryImpl;
import com.utn.dds.tpprevio.service.UsuarioService;
import com.utn.dds.tpprevio.service.impl.UsuarioServiceImpl;

// (se debe tener levantado un MYSQL para probar los test)
public class UsuarioServiceImplTest {

	private UsuarioService usuarioService = new UsuarioServiceImpl(new UsuarioRepositoryImpl());
	private UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();

	@Test
	public void iniciarSesion_conUsernameValido_devuelveTrue() {
		Usuario usuarioExistente = usuarioRepository.buscarPorId("manu"); // usuario existente
		String password = usuarioExistente.getPassword(); // antes 
		assertEquals(true, usuarioService.iniciarSesion("manu", password)); // despues
	}

	@Test
	public void iniciarSesion_conUsernameNull_devuelveFalse() {
		assertEquals(false, usuarioService.iniciarSesion(null, "1234"));
	}

	@Test
	public void iniciarSesion_conUsernameVacio_devuelveFalse() {
		assertEquals(false, usuarioService.iniciarSesion("", "1234"));
	}

	@Test
	public void iniciarSesion_conUsernameInexistente_devuelveFalse() {
		assertEquals(false, usuarioService.iniciarSesion("joni s", "5678"));
	}

	@Test
	public void iniciarSesion_conPasswordNull_devuelveFalse() {
		assertEquals(false, usuarioService.iniciarSesion("manu", null));
	}

	@Test
	public void iniciarSesion_conPasswordVacia_devuelveFalse() {
		assertEquals(false, usuarioService.iniciarSesion("manu", ""));
	}

	@Test
	public void cambiarPassword_conPasswordValida_modificaPassword() {
		usuarioService.cambiarPassword("manu", "otra");
		Usuario usuario = usuarioRepository.buscarPorId("manu");
		assertEquals("otra", usuario.getPassword());
	}

	@Test
	public void cambiarPassword_conPasswordVacia_noModificaPassword() {
		Usuario usuarioExistente = usuarioRepository.buscarPorId("manu");
		String passwordAnterior = usuarioExistente.getPassword();
		
		usuarioService.cambiarPassword("manu", "");
		
		usuarioExistente = usuarioRepository.buscarPorId("manu");
		String passwordActual = usuarioExistente.getPassword();
		
		assertEquals(passwordAnterior, passwordActual);
	}

	@Test
	public void cambiarPassword_conPasswordNull_noModificaPassword() {
		Usuario usuarioExistente = usuarioRepository.buscarPorId("manu");
		String password = usuarioExistente.getPassword();
		usuarioService.cambiarPassword("manu", null);
		assertEquals(password, usuarioRepository.buscarPorId("manu").getPassword());
	}
}
