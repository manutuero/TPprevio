package com.utn.dds.tpprevio.repository;

import java.util.List;

import com.utn.dds.tpprevio.domain.Country;

public interface CountryRepository {
	public void agregar(String codigo_pais, String nombre_pais);
	public Country buscarPorId(String idPais);
	public List<Country> buscarCountries();
}
