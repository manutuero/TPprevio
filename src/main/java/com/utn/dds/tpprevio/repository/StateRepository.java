package com.utn.dds.tpprevio.repository;
import com.utn.dds.tpprevio.domain.State;

public interface StateRepository {
	public void agregar(String codigo_state, String nombre_state,String fk_state);
	public State buscarPorId(String idState);
}
