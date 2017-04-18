package com.utn.dds.tpprevio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utn.dds.tpprevio.repository.impl.UsuarioRepositoryImpl;
import com.utn.dds.tpprevio.service.UsuarioService;
import com.utn.dds.tpprevio.service.impl.UsuarioServiceImpl;

/**
 * Servlet implementation class UsuarioController
 */

public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService = new UsuarioServiceImpl(new UsuarioRepositoryImpl());

	public UsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
		requestDispatcher.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
    	String password = request.getParameter("password");

    	Boolean ingresa = usuarioService.iniciarSesion(username, password);
    	if(ingresa) {
    		response.sendRedirect("bienvenido.jsp");
    	} else {
    		request.setAttribute("error", "La combinacion de usuario y contraseña es incorrecta");
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
    		requestDispatcher.include(request, response);
    	}
    }
}
