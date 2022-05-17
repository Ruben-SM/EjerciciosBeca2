package service;

import java.util.List;

import model.Reserva;

public interface ReservasService {

	public boolean registrar(Reserva reserva, int personas);
	public List<Reserva> mostarReservas();
	
}
