package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cuenta;

public interface CuentasDao extends JpaRepository<Cuenta, Integer> {
 
	
}
