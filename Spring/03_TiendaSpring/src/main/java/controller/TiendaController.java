package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.TiendaService;

@Controller
public class TiendaController {

	@Autowired
	TiendaService tiendaService;
	
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("seccion") String seccion, HttpServletRequest request) {
		List<Producto> productos = tiendaService.buscar(seccion);
		request.setAttribute("productos", productos);
		return "listado"; 
	}
	
	@PostMapping(value="Alta")
	public String alta(@ModelAttribute Producto producto) {
		tiendaService.alta(producto);
		return "listado";
	}
	
	@GetMapping(value="Modificar")
	public String modificar(@RequestParam("nombre") String nombre, @RequestParam("precio") Double precio) {
		tiendaService.modificar(nombre, precio);
		return "inicio";
	
	}
	
	@GetMapping(value="Eliminar")
	public String baja(@RequestParam("nombre") String nombre) {
		tiendaService.baja(nombre);
		return "inicio";
	}
	
}
