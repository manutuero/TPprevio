	/*
package com.utn.dds.tpprevio.log;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.utn.dds.tpprevio.domain.Usuario;

public class Logger {

	public static void logg(Usuario user) {
		JSONObject datos = new JSONObject();
		JSONObject fecha = new JSONObject();
		JSONArray usuario = new JSONArray();
		JSONArray contraseña = new JSONArray();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

		fecha.put("Fecha", hourdateFormat.format(date));

		usuario.add(user.getUsername());
		datos.put("Usuario", usuario);

		contraseña.add(user.getPassword());
		datos.put("Contraseña", contraseña);

		try {
			
			FileWriter file = new FileWriter("Logger.json", true);
			file.write(fecha.toJSONString());
			file.write(datos.toJSONString() + "\n");
			file.flush();

		} catch (IOException e) {
			// manejar error
		}
	}
}

*/