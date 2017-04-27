package com.utn.dds.tpprevio.repository;
import java.util.List;

import com.utn.dds.tpprevio.domain.Country;
import com.utn.dds.tpprevio.domain.State;

public interface StateRepository {
	public void agregar(String codigo_state, String nombre_state, String fk_country);
	public State buscarPorId(String idState);
	public List<State> buscarStates(Country country);
}
