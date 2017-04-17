package com.utn.dds.tpprevio;

import static org.junit.Assert.*;
import org.junit.Test;
import com.utn.dds.tpprevio.repository.impl.ConnectionManager;

public class ConnectionManagerTest {	

	@Test
	public void getMYSQLConnection_conParametrosValidos_devuelveConexion() throws ClassNotFoundException {
		assertEquals("com.mysql.jdbc.JDBC4Connection",
				ConnectionManager.getConnection().getClass().getName());
	}
	
	@Test(expected = ClassNotFoundException.class)
	public void getMYSQLConnection_conParametrosNoValidos_devuelveExcepcion() throws ClassNotFoundException {
		assertNotNull(ConnectionManager.getConnection("url no valida"," driver no valido"));
	}
}
