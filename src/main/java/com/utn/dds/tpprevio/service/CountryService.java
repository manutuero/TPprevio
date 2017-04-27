package com.utn.dds.tpprevio.service;

import java.util.List;

import com.utn.dds.tpprevio.domain.Country;
import com.utn.dds.tpprevio.domain.State;

public interface CountryService {
	public void agregarPais(String codigo_pais, String nombre_pais);
	public Country buscarPorId(String idPais);
	public void actualizarBase(Country country, List<State> states);
}
