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
		
    public UsuarioController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	Boolean ingresa = usuarioService.iniciarSesion(username, password);
    	System.out.println("Entra al post");
    
    	if(ingresa) {
    		request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
    		System.out.println("LLEGA!!!");
    	}else {
			System.out.println("No entro al servidor.");
			response.sendRedirect("index.html");
    	}
    }
       
}
