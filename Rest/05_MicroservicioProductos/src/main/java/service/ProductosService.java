package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	
	void alta(Producto p);
	boolean baja(int id);
	Producto buscarPorId(int id);
	List<Producto> buscar(String seccion);
	List<Producto> buscarTodos();

}
