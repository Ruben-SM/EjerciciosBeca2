package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimiento;

public interface MovimientosDao extends JpaRepository<Movimiento, Integer>{
	
	List<Movimiento> findByIdCuentaAndFechaBetween(int numCuenta, Date fechaIni, Date fechaFin);
}
