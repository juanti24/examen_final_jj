package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IAvionRepo;
import com.uce.edu.demo.repository.modelo.Avion;

@Service
public class AvionServiceImpl implements IAvionService{

	@Autowired
	private IAvionRepo avionRepo;

	@Override
	public void create(Avion avion) {
		// TODO Auto-generated method stub
		this.avionRepo.insertarAvion(avion);
	}

	@Override
	public Avion read(Integer id) {
		// TODO Auto-generated method stub
		return this.avionRepo.buscarAvionPorId(id);
	}

	@Override
	public void update(Avion avion) {
		// TODO Auto-generated method stub
		this.avionRepo.actualizarAvion(avion);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.avionRepo.borrarAvionPorId(id);
	}
}