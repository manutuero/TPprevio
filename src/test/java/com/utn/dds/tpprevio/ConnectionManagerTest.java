package com.utn.dds.tpprevio;

import static org.junit.Assert.*;
import org.junit.Test;
import com.utn.dds.tpprevio.repository.impl.ConnectionManager;

public class ConnectionManagerTest {	
	@Test
	public void getConnection_conParametrosValidos_devuelveConexion() throws ClassNotFoundException {
		assertEquals(ConnectionManager.getConnection().getClass().getName(),
				"org.hsqldb.jdbc.JDBCConnection");
	}
	
	@Test(expected = ClassNotFoundException.class)
	public void getConnection_conParametrosNoValidos_devuelveExcepcion() throws ClassNotFoundException {
		assertNotNull(ConnectionManager.getConnection("url no valida"," driver no valido"));
	}
}
