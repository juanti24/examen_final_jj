package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloRepo {

	public void create(Vuelo vuelo);
	
	public Vuelo read(Integer id); 
	
	public void update(Vuelo vuelo); 
	
	public void delete(Integer id); 
	
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, String fechaVuelo);
	
	public Vuelo buscarNumero(String numeroVuelo);
}
	