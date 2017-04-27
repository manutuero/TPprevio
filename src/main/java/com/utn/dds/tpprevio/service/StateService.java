package com.utn.dds.tpprevio.service;

import java.util.List;

import com.utn.dds.tpprevio.domain.Country;
import com.utn.dds.tpprevio.domain.State;

public interface StateService {
	public void agregarPais(String codigo_state, String nombre_state, String fk_state);
	public State buscarPorId(String idState);
	public List<State> buscarStates(Country country);
}
