package com.utn.dds.tpprevio.service.impl;
import java.util.List;

import com.utn.dds.tpprevio.domain.Country;
import com.utn.dds.tpprevio.domain.State;
import com.utn.dds.tpprevio.repository.CountryRepository;
import com.utn.dds.tpprevio.repository.StateRepository;
import com.utn.dds.tpprevio.repository.impl.CountryRepositoryImpl;
import com.utn.dds.tpprevio.repository.impl.StateRepositoryImpl;
import com.utn.dds.tpprevio.service.CountryService;

public class CountryServiceImpl implements CountryService {
    
	private CountryRepository countryRepository = new CountryRepositoryImpl();
	private StateRepository stateRepository = new StateRepositoryImpl();
	
    public void agregarPais(String codigo_pais, String nombre_pais) {
    	
    }
	public Country buscarPorId(String idPais) {
		return null;
	}
	public void actualizarBase(Country country, List<State> states) {
		countryRepository.agregar(country.getId(), country.getName());
		for(int i=0; i < states.size(); i++) {
			State state = states.get(i);
			//System.out.println(state.getName());	
			stateRepository.agregar(state.getId(), state.getName(), country.getId());
		}
	}
}
