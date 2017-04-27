package com.utn.dds.tpprevio.service;

import java.util.List;

import com.utn.dds.tpprevio.domain.Country;
import com.utn.dds.tpprevio.domain.State;

public interface CountryService {
	public void actualizarBase(Country country, List<State> states);
	public List<Country> buscarCountries();
}
