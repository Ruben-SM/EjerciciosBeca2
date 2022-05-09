package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisService;

@CrossOrigin("*")
@RestController
public class PaisesController {

	@Autowired
	PaisService service;
	
	@GetMapping(value = "continentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> listaContinentes(){
		return service.listaContinentes();
	}
	
	@GetMapping(value = "continente/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> listaPaisesContinente(@PathVariable("continente") String continente){
		return service.listaPaisesPorContinente(continente);
	}
	
	@GetMapping(value = "poblacion/{continente}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String poblacionContinente(@PathVariable("continente") String continente) {
		return String.valueOf(service.habitantesContinente(continente));
	}

}
