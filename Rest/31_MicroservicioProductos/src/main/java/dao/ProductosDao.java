package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Producto;

public interface ProductosDao extends JpaRepository<Producto,Integer>{

	@Query("select p from Producto p where p.stock > 0 ")
	List<Producto> findProductosDisponibles();
}
