package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Avion;

public interface IAvionService {

	public void create(Avion avion);
	
	public Avion read(Integer id); 
	
	public void update(Avion avion); 
	
	public void delete(Integer id); 
	
}
