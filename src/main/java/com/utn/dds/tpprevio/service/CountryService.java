package com.utn.dds.tpprevio.service;

public interface CountryService {
	public void agregarPais(String codigo_pais,String nombre_pais);
	public String buscarPaisPorId(String idPais);
}
