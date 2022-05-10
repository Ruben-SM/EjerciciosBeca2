package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Vuelo;


public interface VuelosDao extends JpaRepository<Vuelo,Integer> {

	
}
