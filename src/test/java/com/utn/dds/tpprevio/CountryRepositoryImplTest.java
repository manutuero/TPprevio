package com.utn.dds.tpprevio;

import static org.junit.Assert.*;

import org.junit.Test;
import com.utn.dds.tpprevio.repository.CountryRepository;
import com.utn.dds.tpprevio.repository.impl.CountryRespositoryImpl;;

public class CountryRepositoryImplTest {
	
	private CountryRepository countryRepository = new CountryRespositoryImpl();
	@Test
	public void agregarPais() {
	  countryRepository.agregarPais("AR", "Argentina");
	  assertEquals("Argentina",countryRepository.buscarPaisPorId("AR"));
	}

}
