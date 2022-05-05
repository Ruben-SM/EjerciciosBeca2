package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Pagina;

@Service//hace que Spring cree una instancia de la clase
public class BuscadorServiceImpl implements BuscadorService {
	static ArrayList<Pagina> paginas=new ArrayList<>();
	public BuscadorServiceImpl() {
		paginas.add(new Pagina("http://www.fnac.es","libros","Libros y más cosas"));
		paginas.add(new Pagina("http://www.gamer.es","juegos","Juegos on-line"));
		paginas.add(new Pagina("http://www.casadellibro.es","libros","La Web de los libros"));
		paginas.add(new Pagina("http://www.mydisc.es","musica","Música de todo tipo"));
		paginas.add(new Pagina("http://www.radio.es","musica","Música de actualidad"));
	}
	@Override
	public List<Pagina> buscar(String tematica) {
		return paginas
				.stream()
				.filter(p->p.getTematica().equals(tematica))
				.collect(Collectors.toList());
	}
	@Override
	public void alta(Pagina pagina) {
		paginas.add(pagina);
		
	}
	@Override
	public List<Pagina> paginas() {
		return paginas;
	}
	
	@Override
	public void eliminar(String tematica) {
		paginas.removeIf(p-> p.getTematica().equals(tematica));
		
	}
	@Override
	public Pagina actualizar(Pagina pagina) {
		for (int i = 0; i < paginas.size(); i++) {
			if (paginas.get(i).getDireccion().equals(pagina.getDireccion())) {
				paginas.set(i, pagina);
				return pagina;
			}
		}
		return null;	// la pagina no existe
	}
	@Override
	public void actualizarTematica(String direccion, String nuevaTematica) {
		paginas.forEach(p -> {
			if (p.getDireccion().equals(direccion)) {
				p.setTematica(nuevaTematica);
			}
		});
	}
	
	
}
