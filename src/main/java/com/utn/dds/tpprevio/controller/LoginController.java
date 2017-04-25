package com.utn.dds.tpprevio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utn.dds.tpprevio.repository.impl.UsuarioRepositoryImpl;
import com.utn.dds.tpprevio.service.UsuarioService;
import com.utn.dds.tpprevio.service.impl.UsuarioServiceImpl;
import com.utn.dds.tpprevio.domain.Usuario;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService = new UsuarioServiceImpl(new UsuarioRepositoryImpl());

	public LoginController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
    	String password = request.getParameter("password");

    	Boolean ingresa = usuarioService.iniciarSesion(username, password);
    	
    	RequestDispatcher requestDispatcher = null;
    	
    	if(ingresa) {
    		Usuario usuario = new Usuario();
    		usuario.setUsername(username);
    		usuario.setPassword(password);
    		
    		HttpSession httpSession = request.getSession(true); // si no le paso nada tambien crea la sesion por defecto
    		httpSession.setAttribute("username", username); // httpSession es un HashMap ("clave" = valor)
    		httpSession.setAttribute("password", password);
    		
    		requestDispatcher = request.getRequestDispatcher("/WEB-INF/bienvenido.jsp");
    		requestDispatcher.forward(request, response);
    	} else {
    		request.setAttribute("error", "La combinacion de usuario y contraseña es incorrecta");
    		requestDispatcher = request.getRequestDispatcher("login.jsp");
    		requestDispatcher.include(request, response);
    	}
    }
}
