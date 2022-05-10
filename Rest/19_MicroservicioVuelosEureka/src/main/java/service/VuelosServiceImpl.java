package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService {

	VuelosDao vuelosDao;
	
	public VuelosServiceImpl(@Autowired VuelosDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}

	@Override
	public List<Vuelo> vuelosDisponibles(int plazas) {
		return vuelosDao.findAll()
				.stream()
				.filter(v-> v.getPlazas() >= plazas)
				.collect(Collectors.toList());
	}

	@Override
	public boolean actualizarVuelo(int idVuelo, int plazasReservadas) {
		Optional<Vuelo> vuelo = vuelosDao.findById(idVuelo);
		
		if (!vuelo.isEmpty()) {
			Vuelo v = vuelo.get(); 
			int nPlazas = v.getPlazas();
			if (nPlazas >= plazasReservadas) {
				v.setPlazas(nPlazas-plazasReservadas);
				vuelosDao.save(v);
				return true;
			}
		}
		
		return false;
	}

}
