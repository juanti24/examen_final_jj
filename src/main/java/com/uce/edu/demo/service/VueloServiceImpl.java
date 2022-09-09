package com.uce.edu.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepo;
import com.uce.edu.demo.repository.modelo.Vuelo;


@Service
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepo vueloRepo;

	@Override
	public void create(Vuelo vuelo) {
		this.vueloRepo.create(vuelo);
		
	}

	@Override
	public Vuelo read(Integer id) {
		// TODO Auto-generated method stub
		return this.vueloRepo.read(id);
	}

	@Override
	public void update(Vuelo vuelo) {
		this.vueloRepo.update(vuelo);
		
	}

	@Override
	public void delete(Integer id) {
		this.vueloRepo.delete(id);
		
	}

	@Override
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, String fechaVuelo) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarVuelosDisponibles(origen, destino, fechaVuelo);
	}

	@Override
	public List<Vuelo> busquedaParalelo(String origen, String destino, String fechaVuelo) {
		List<Vuelo> listaVuelos=this.buscarVuelosDisponibles(origen, destino, fechaVuelo);
		
		//Busqueda
		List<Vuelo> vueloEconomico=listaVuelos.parallelStream().filter(v->v.getCategoria().equalsIgnoreCase("E")&&v.getEstado().equalsIgnoreCase("D")).collect(Collectors.toList());
		List<Vuelo> vueloNegocios=listaVuelos.parallelStream().filter(v->v.getCategoria().equalsIgnoreCase("N")&&v.getEstado().equalsIgnoreCase("D")).collect(Collectors.toList());
		List<Vuelo> vueloTurista=listaVuelos.parallelStream().filter(v->v.getCategoria().equalsIgnoreCase("T")&&v.getEstado().equalsIgnoreCase("D")).collect(Collectors.toList());
		
		//Concateno
		List<Vuelo> vuelosDisponibles=Stream.concat(vueloEconomico.stream(), vueloNegocios.stream()).collect(Collectors.toList());
		vuelosDisponibles=Stream.concat(vuelosDisponibles.stream(), vueloTurista.stream()).collect(Collectors.toList());
		return vuelosDisponibles;
	}

	@Override
	public Vuelo buscarNumero(String numeroVuelo) {
		
		return this.vueloRepo.buscarNumero(numeroVuelo);
	}

	
	


}
