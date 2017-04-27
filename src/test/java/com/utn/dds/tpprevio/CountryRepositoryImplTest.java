package com.utn.dds.tpprevio;

import static org.junit.Assert.*;

import org.junit.Test;
import com.utn.dds.tpprevio.repository.CountryRepository;
import com.utn.dds.tpprevio.repository.impl.CountryRepositoryImpl;;

public class CountryRepositoryImplTest {
	
	private CountryRepository countryRepository = new CountryRepositoryImpl();
	
	@Test
	public void agregar_conPaisValido_agregaCorrectamente() {
	  countryRepository.agregar("AR", "Argentina");
	  assertEquals("Argentina",countryRepository.buscarPorId("AR").getName());
	}
}
