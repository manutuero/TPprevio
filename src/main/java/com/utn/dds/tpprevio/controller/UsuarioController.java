package com.utn.dds.tpprevio.controller;

import java.io.IOException;

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
<<<<<<< HEAD

	public UsuarioController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
=======
		
    public UsuarioController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String username = request.getParameter("username");
>>>>>>> 363425081e58aa1eab0c249c7ec55fae8b78cef0
    	String password = request.getParameter("password");

    	Boolean ingresa = usuarioService.iniciarSesion(username, password);
<<<<<<< HEAD
        
    	if(ingresa) {
        	response.sendRedirect("bienvenido.jsp");;
        }else {
        	
        }
=======
    	System.out.println("Entra al post");
    
    	if(ingresa) {
    		request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
    		System.out.println("LLEGA!!!");
    	}else {
			System.out.println("No entro al servidor.");
			response.sendRedirect("index.html");
    	}
>>>>>>> 363425081e58aa1eab0c249c7ec55fae8b78cef0
    }
}
