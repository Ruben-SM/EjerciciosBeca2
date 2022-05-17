package service;

import java.util.List;

import model.Pais;

public interface PaisService {

	List<String> listaContinentes();
	List<Pais> listaPaisesPorContinente(String continente);
	Long habitantesContinente(String continente);
	
}
