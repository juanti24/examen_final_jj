package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Cliente;

public interface IClienteRepo {
	
	public void insertarCliente(Cliente cliente);
	
	public void actualizarCliente(Cliente cliente);
	
	public Cliente buscarClientePorId(Integer id);
	
	public void borrarClientePorId(Integer id);

}
