package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {

	HotelesDao hotelesDao;
	
	
	public HotelesServiceImpl(@Autowired HotelesDao hotelesDao) {
		super();
		this.hotelesDao = hotelesDao;
	}

	@Override
	public List<Hotel> hotelesDisponibles() {
		return hotelesDao.findAll()
				.stream()
				.filter(h -> h.getDisponible() ==1)
				.collect(Collectors.toList());
	}

	@Override
	public Hotel datosHotel(String nombre) {
		return hotelesDao.findByNombre(nombre);
	}

	@Override
	public Hotel hotelId(int id) {
		return hotelesDao.findById(id).orElse(null);
	}

}
