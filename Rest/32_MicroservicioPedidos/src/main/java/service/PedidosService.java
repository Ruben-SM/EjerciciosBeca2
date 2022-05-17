package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {

	boolean altaPedido(Pedido pedido);
	List<Pedido> listarPedidos();
}
