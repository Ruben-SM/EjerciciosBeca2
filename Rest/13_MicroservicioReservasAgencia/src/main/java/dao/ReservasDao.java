package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Reserva;

public interface ReservasDao extends JpaRepository<Reserva,Integer>  {

}
