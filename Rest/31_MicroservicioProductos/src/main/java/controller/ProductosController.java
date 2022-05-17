package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;

@CrossOrigin("*")
@RestController
public class ProductosController {

	@Autowired
	ProductosService service;
	
	@GetMapping(value ="productos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> buscarProductosDisponibles(){
		return service.listaProductosExistentes();
	}
	
	@PutMapping(value = "producto/{codigoProducto}/{unidades}" , produces = MediaType.TEXT_PLAIN_VALUE)
	public String comprarProducto(@PathVariable("codigoProducto")int codigoProducto, @PathVariable("unidades") int unidades) {
		return String.valueOf(service.actualizarStock(codigoProducto, unidades));
	}
	
	@GetMapping(value ="producto/{codigoProducto}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String consultarPrecio(@PathVariable("codigoProducto") int codigoProducto){
		return String.valueOf(service.mostrarPrecio(codigoProducto));
	}

}
