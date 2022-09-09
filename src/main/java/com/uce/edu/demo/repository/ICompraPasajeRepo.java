package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CompraPasaje;

public interface ICompraPasajeRepo {

	public void insertarCompraPasaje(CompraPasaje compraPasaje);
	
	public void actualizarCompraPasaje(CompraPasaje compraPasaje);
	
	public CompraPasaje buscarCompraPasajePorId(Integer id);
	
	public void borrarCompraPasajePorId(Integer id);
	
	public CompraPasaje buscarCompraPasajePorNumero(String numeroCompra);
	
}
