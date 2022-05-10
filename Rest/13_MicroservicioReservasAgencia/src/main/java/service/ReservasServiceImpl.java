package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Hotel;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservasServiceImpl implements ReservasService {

	ReservasDao reservasDao;
	RestTemplate template;

	String urlVuelos="http://localhost:8001/agencia/";
	String urlHoteles="http://localhost:8000/agencia/";


	public ReservasServiceImpl(@Autowired ReservasDao reservasDao, @Autowired RestTemplate template) {
		super();
		this.reservasDao = reservasDao;
		this.template = template;
	}

	@Override
	public boolean registrar(Reserva reserva, int personas) {
		Vuelo[] vuelos = template.getForObject(urlVuelos+"disponibles/"+personas, Vuelo[].class);
		Hotel hotel = template.getForObject(urlHoteles+"hoteles/"+reserva.getHotel(), Hotel.class);
		
		List<Vuelo> vuelo = Arrays.stream(vuelos)
				.filter(v-> v.getIdvuelo() == reserva.getVuelo() && v.getPlazas() >= personas)
				.collect(Collectors.toList());

		
		if (!vuelo.isEmpty() && hotel.getDisponible()==1){
			reservasDao.save(reserva);
			template.put(urlVuelos+"vuelo/"+reserva.getVuelo()+"/"+personas,Vuelo.class);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Reserva> mostarReservas() {
		return reservasDao.findAll();
	}
	
	
}
