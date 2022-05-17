package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pedido;
import service.PedidosService;

@CrossOrigin("*")
@RestController
public class PedidosController {

	@Autowired
	PedidosService service;
	
	@PostMapping(value ="pedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String crearPedido(@RequestBody Pedido pedido){
		return String.valueOf(service.altaPedido(pedido));
	}
	
	@GetMapping(value="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> verPedidos(){
		return service.listarPedidos();
	}
}
