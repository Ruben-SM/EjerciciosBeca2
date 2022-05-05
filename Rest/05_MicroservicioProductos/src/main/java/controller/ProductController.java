package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;


@RestController
public class ProductController {

	@Autowired
	ProductosService service;
	
	@PostMapping(value="Producto",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody Producto producto) {
		service.alta(producto);
	}

	@DeleteMapping(value="Producto/{idProducto}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String baja(@PathVariable("idProducto") int idAlumno) {
		return String.valueOf(service.baja(idAlumno));
	}
	
	@GetMapping(value ="Productos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> buscarProductos(){
		return service.buscarTodos();
	}
	
	@GetMapping(value ="Productos/{seccion}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> buscarProductosPorSeccion(@PathVariable("seccion") String seccion){
		return service.buscar(seccion);
	}

}
