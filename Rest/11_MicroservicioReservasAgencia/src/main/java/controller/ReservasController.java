package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Reserva;
import service.ReservasService;

@RestController
public class ReservasController {

	@Autowired
	ReservasService service;
	
	@PostMapping(value = "reservar" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String reservar(@RequestParam("personas") int personas, @RequestBody Reserva reserva ) {
		
		return String.valueOf(service.registrar(reserva, personas));
	}
	
	@GetMapping(value = "reservas", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> mostrarReservas(){
		return service.mostarReservas();
	}
}
