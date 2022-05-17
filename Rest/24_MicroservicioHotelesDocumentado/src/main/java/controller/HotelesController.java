package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Hotel;
import service.HotelesService;

@CrossOrigin("*")
@RestController
public class HotelesController {

	@Autowired
	HotelesService service;
	// @Value("#{spring.application.name}")
	String data;
	
	@ApiOperation(value = "Devuelve una Lista JSON con los datos de los hoteles disponibles")
	@GetMapping(value ="disponibles",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> buscarHotelesDisponibles(){
		return service.hotelesDisponibles();
	}
	
	@ApiOperation(value = "Devuelve los datos del hotel cuyo nombre recibe en URL")
	@GetMapping(value ="hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotelNombre(@ApiParam(value = "Nombre del hotel a buscar")
									@PathVariable("nombre") String nombre) {
		return service.datosHotel(nombre);
	}
	
	@ApiOperation(value = "Devuelve los datos del hotel cuyo id recibe en URL")
	@GetMapping(value ="hoteles/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotelId(@ApiParam(value = "id del hotel a buscar")
								@PathVariable("id") int id) {
		return service.hotelId(id);
	}
}
