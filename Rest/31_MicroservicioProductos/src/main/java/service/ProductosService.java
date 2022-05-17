package service;

import java.util.List;

import model.Producto;

public interface ProductosService {

	List<Producto> listaProductosExistentes();
	boolean actualizarStock(int codigoProducto, int unidades);
	double mostrarPrecio(int codigoProducto);
	
}
