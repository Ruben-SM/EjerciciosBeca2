package service;

import java.util.List;

import model.Pagina;

public interface BuscadorService {
	List<Pagina> buscar(String tematica);
	void alta(Pagina pagina);
	List<Pagina> paginas();
	void eliminar(String tematica);
	Pagina actualizar(Pagina pagina);
	void actualizarTematica(String direccion, String nuevaTematica);
}
