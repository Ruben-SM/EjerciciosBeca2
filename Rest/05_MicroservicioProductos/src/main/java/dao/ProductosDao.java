package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Producto;

public interface ProductosDao extends JpaRepository<Producto,Integer>{
	
	List<Producto> findBySeccion(String seccion);

}
