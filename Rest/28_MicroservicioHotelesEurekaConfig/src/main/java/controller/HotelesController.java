package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
import service.HotelesService;

@CrossOrigin("*")
@RestController
public class HotelesController {

	@Autowired
	HotelesService service;
	
	@GetMapping(value ="disponibles",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> buscarHotelesDisponibles(){
		return service.hotelesDisponibles();
	}
	
	@GetMapping(value ="hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotelNombre(@PathVariable("nombre") String nombre) {
		return service.datosHotel(nombre);
	}
	
	@GetMapping(value ="hoteles/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotelId(@PathVariable("id") int id) {
		return service.hotelId(id);
	}
}
