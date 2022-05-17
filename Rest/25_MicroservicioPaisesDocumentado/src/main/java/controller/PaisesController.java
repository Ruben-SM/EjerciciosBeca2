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
import model.Pais;
import service.PaisService;

@CrossOrigin("*")
@RestController
public class PaisesController {

	@Autowired
	PaisService service;
	String data;
	
	@ApiOperation(value = "Devuelve la lista de continentes en una lista JSON")
	@GetMapping(value = "continentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> listaContinentes(){
		return service.listaContinentes();
	}
	
	@ApiOperation(value = "Devuelve una lista de paises del continente recibido en la URL")
	@GetMapping(value = "continente/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> listaPaisesContinente(@ApiParam(value = "continente a buscar paises")
											@PathVariable("continente") String continente){
		return service.listaPaisesPorContinente(continente);
	}
	
	@ApiOperation(value = "Devuelve el numero de habitantes que tiene el continente recibido en la URL")
	@GetMapping(value = "poblacion/{continente}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String poblacionContinente(@ApiParam(value = "continente a buscar habitantes")
										@PathVariable("continente") String continente) {
		return String.valueOf(service.habitantesContinente(continente));
	}

}
