package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Avion;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.service.IAvionService;
import com.uce.edu.demo.service.IVueloService;

@SpringBootApplication
public class ExamenFinalJjApplication implements CommandLineRunner{
	
	@Autowired
	IAvionService avionService;
	
	@Autowired
	private IVueloService vueloService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ExamenFinalJjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Avion avion=new Avion();
		avion.setCapacidadAsientos(120);
		avion.setNombre("America");
		
		
		Vuelo vuelo = new Vuelo();
		vuelo.setAsientosDisponibles(50);
		vuelo.setAvion(avion);
		vuelo.setCategoria("T");
		vuelo.setDestino("Miami");
		vuelo.setEstado("D");
		vuelo.setFechaVuelo("09-09-12");
		vuelo.setNumeroVuelo("A23");
		vuelo.setValorAsiento(new BigDecimal(20));
		vuelo.setOrigen("Mexico");
		
		List<Vuelo> vuelos = new ArrayList();
		vuelos.add(vuelo);
		
		avion.setVuelos(vuelos);
	
		this.vueloService.create(vuelo);
		
		Cliente clie = new Cliente();
		clie.setNombre("Juan");
		clie.setApellido("Jumbo");
		clie.setCedula("1723920979");
		
		CompraPasaje cp = new CompraPasaje();
		cp.setCantidadAsientosComprados(50);
		cp.setCliente(clie);
		cp.setEstado("R");
		cp.setFechaCompra("09-09-12");
		cp.setNumero("A32");
		cp.setNumeroTarjeta("1748457414");
		cp.setVuelo(vuelo);
		
		List<CompraPasaje> pasajes = new ArrayList();
		pasajes.add(cp);
		
		
		
	}

}
