package service;

import java.util.List;

import model.Producto;

public interface TiendaService {

	List<Producto> buscar(String seccion);
	void alta(Producto producto);
	void baja(String nombre);
	void modificar(String nombre, double nuevoPrecio);
	Producto buscarPorID(String idProducto);
	Producto buscarPorNombre(String nombre);
}
