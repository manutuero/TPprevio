package com.utn.dds.tpprevio.service;

import com.utn.dds.tpprevio.domain.Country;

public interface CountryService {
	public void agregarPais(String codigo_pais, String nombre_pais);
	public Country buscarPorId(String idPais);
}
