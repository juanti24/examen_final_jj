package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepo;
import com.uce.edu.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteRepo clienteRepo;

	@Override
	public void create(Cliente cliente) {
		this.clienteRepo.insertarCliente(cliente);
		
	}

	@Override
	public Cliente read(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarClientePorId(id);
	}

	@Override
	public void update(Cliente cliente) {
		this.clienteRepo.actualizarCliente(cliente);
		
	}

	@Override
	public void delete(Integer id) {
		this.clienteRepo.borrarClientePorId(id);
		
	}

}
