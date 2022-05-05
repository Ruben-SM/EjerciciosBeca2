package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Producto;
import service.TiendaService;

@CrossOrigin("*")
@Controller
public class TiendaController {

	@Autowired
	TiendaService tiendaService;
	
	@GetMapping(value="Buscador", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Producto> buscar(@RequestParam("seccion") String seccion, HttpServletRequest request) {
		return tiendaService.buscar(seccion);
	}
	
	@PostMapping("Alta")
	public String alta(@ModelAttribute Producto producto) {
		tiendaService.alta(producto);
		return "alta";
	}
	
	@GetMapping("Modificar")
	public String modificar(@RequestParam("nombre") String nombre, @RequestParam("precio") Double precio) {
		tiendaService.modificar(nombre, precio);
		return "inicio";
	
	}
	
	@GetMapping("Eliminar")
	public String baja(@RequestParam("nombre") String nombre) {
		tiendaService.baja(nombre);
		return "inicio";
	}
	
}
