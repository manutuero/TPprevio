package com.utn.dds.tpprevio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.utn.dds.tpprevio.domain.Usuario;
import com.utn.dds.tpprevio.repository.UsuarioRepository;
import com.utn.dds.tpprevio.repository.impl.UsuarioRepositoryImpl;
import com.utn.dds.tpprevio.service.UsuarioService;
import com.utn.dds.tpprevio.service.impl.UsuarioServiceImpl;

public class UsuarioServiceImplTest {

	private UsuarioService usuarioService = new UsuarioServiceImpl(new UsuarioRepositoryImpl());
	private UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();

	@Before
	public void initDatabase() {
		usuarioRepository.initDatabaseInMemory();
	}
	/*
	@Test
	public void iniciarSesion_conUsuarioValido_devuelveMensajeBienvenido() {
		Boolean ingresa = usuarioService.iniciarSesion("manu", "1234");
		assertEquals("Bienvenido! manu.", ingresa);
	}

	@Test
	public void iniciarSesion_conUsuarioNull_devuelveMensajeError() {
		String respuesta = usuarioService.iniciarSesion(null, "1234");
		assertEquals("El usuario ingresado no existe.", respuesta);
	}

	@Test
	public void iniciarSesion_conUsuarioVacio_devuelveMensajeError() {
		String respuesta = usuarioService.iniciarSesion("", "1234");
		assertEquals("El usuario ingresado no existe.", respuesta);
	}

	@Test
	public void iniciarSesion_conUsuarioNoExistente_devuelveMensajeError() {
		String respuesta = usuarioService.iniciarSesion("joni s", "5678");
		assertEquals("El usuario ingresado no existe.", respuesta);
	}

	@Test
	public void iniciarSesion_conContraseñaNull_devuelveMensajeError() {
		String respuesta = usuarioService.iniciarSesion("manu", null);
		assertEquals("Error, debe ingresar una contraseña.", respuesta);
	}

	@Test
	public void iniciarSesion_conContraseñaNoVacia_devuelveMensajeError() {
		String respuesta = usuarioService.iniciarSesion("manu", "");
		assertEquals("Error, debe ingresar una contraseña.", respuesta);
	}

	@Test
	public void cambiarPassword_conPasswordValida_modificaPasswordCorrectamente() {
		usuarioService.cambiarPassword("manu", "nueva");
		Usuario usuario = usuarioRepository.buscarPorId("manu");
		assertEquals("nueva", usuario.getPassword());
	}

	@Test
	public void cambiarPassword_conPasswordVacia_devuelveMensajeError() {
		String respuesta = usuarioService.cambiarPassword("manu", "");
		assertEquals("Debe ingresar una contraseña.", respuesta);
	}

	@Test
	public void cambiarPassword_conPasswordNull_devuelveMensajeError() {
		String respuesta = usuarioService.cambiarPassword("manu", null);
		assertEquals("Debe ingresar una contraseña.", respuesta);
	}
	*/
}
