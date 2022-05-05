package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Repository
public class AlumnosDaoImpl implements AlumnosDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Alumno findByUsuarioAndPassword(String usuario, String password) {
		String jpql = "select a from Alumno a where a.usuario =: u and a.password =: p";
		List<Alumno> alumnos = entityManager.createQuery(jpql, Alumno.class)
				.setParameter("u", usuario)
				.setParameter("p", password)
				.getResultList();
		
		return alumnos.size()>0 ? alumnos.get(0) : null;
	}

	@Override
	public List<Alumno> findByCurso(String nombreCurso) {
		String jpql = "select a from Alumno a join a.cursos c where c.nombre =?1";
		return entityManager.createQuery(jpql,Alumno.class)
				.setParameter(1, nombreCurso)
				.getResultList();
	}

	@Override
	public Alumno findById(String usuario) {
		return entityManager.find(Alumno.class, usuario);
	}

	@Transactional
	@Override
	public void update(Alumno alumno) {
		entityManager.merge(alumno);

	}

	@Override
	public List <Alumno> findAll() {
		String jpql = "select a from Alumno a";
		return entityManager.createQuery(jpql,Alumno.class).getResultList();
		

	}

}
