package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;

@Service
public class TiendaServiceImpl implements TiendaService {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public List<Producto> buscar(String seccion) {
		String jpql = "select p from Producto p where p.seccion=: s";
		TypedQuery<Producto> query = entityManager.createQuery(jpql, Producto.class);
		query.setParameter("s", seccion);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void alta(Producto producto) {
		entityManager.persist(producto);
	}

	@Transactional
	@Override
	public void baja(String nombre) {		
		String jpql = "delete from Producto p where p.nombre=:n";
		entityManager.createQuery(jpql)
			.setParameter("n", nombre)
			.executeUpdate();

	}
	
	@Transactional
	@Override
	public void modificar(String nombre, double nuevoPrecio) {
		String jpql = "update Producto p set p.precio =: prec where p.nombre =:n";
		entityManager.createQuery(jpql)
			.setParameter("prec",nuevoPrecio)
			.setParameter("n", nombre)
			.executeUpdate();
		
	}

	@Override
	public Producto buscarPorID(String idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}

	@Override
	public Producto buscarPorNombre(String nombre) {
		String jpql = "select p from Producto p where p.nombre=: n";
		List<Producto> productos = entityManager.createQuery(jpql,Producto.class)
				.setParameter("n", nombre)
				.getResultList();
		return productos.size()>0 ? productos.get(0) : null;

	}


}
