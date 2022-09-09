package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Cliente;

public interface IClienteService {

	
	public void create(Cliente cliente);
	
	public Cliente read(Integer id); 
	
	public void update(Cliente cliente); 
	
	public void delete(Integer id); 
}
