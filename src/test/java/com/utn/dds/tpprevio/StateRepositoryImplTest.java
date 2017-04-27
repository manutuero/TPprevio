package com.utn.dds.tpprevio;
import static org.junit.Assert.*;

import org.junit.Test;

import com.utn.dds.tpprevio.repository.CountryRepository;
import com.utn.dds.tpprevio.repository.StateRepository;
import com.utn.dds.tpprevio.repository.impl.CountryRepositoryImpl;
import com.utn.dds.tpprevio.repository.impl.StateRepositoryImpl;


public class StateRepositoryImplTest {
private StateRepository stateRepository = new StateRepositoryImpl();
private CountryRepository countryRepository = new CountryRepositoryImpl();	
	@Test
	public void agregar_conStateValido_agregaCorrectamente() {
		countryRepository.agregar("ARGP","Argentina prueba");
		stateRepository.agregar("BS", "Buenos Aires","ARGP");
	  assertEquals("Buenos Aires",stateRepository.buscarPorId("BS").getName());
	}
}
