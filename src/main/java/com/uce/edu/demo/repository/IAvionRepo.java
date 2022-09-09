package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Avion;

public interface IAvionRepo {
	
	void insertarAvion(Avion avion);
	
	void actualizarAvion(Avion avion);
	
	Avion buscarAvionPorId(Integer id);
	
	void borrarAvionPorId(Integer id);


}
