package com.utn.dds.tpprevio.repository;

public interface CountryRepository {
	public void agregarPais(String codigo_pais,String nombre_pais);
	public String buscarPaisPorId(String idPais);
}
