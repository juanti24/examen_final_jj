package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.service.IVueloService;

@Controller
@RequestMapping("/clientes/")
public class ClienteController {
	
	@Autowired
	private IVueloService vueloService;
	
	@GetMapping("buscarVuelos")
	public String obtenerPaginaIngresoDatos(Vuelo vuelo) {
		return "buscarVuelos";

	}


	@GetMapping("mostrar/vuelosDisponibles")
	public String mostrarVuelos(Vuelo vuelo, Model modelo) {
		List<Vuelo> vuelos=this.vueloService.busquedaParalelo(vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFechaVuelo());
		modelo.addAttribute("vuelos", vuelos);
		return "mostrarVuelos";

	}

}


