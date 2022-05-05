package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Alumno> buscarCurso(String curso) {
		String jpql = "select a from Alumno a where a.curso=:c";
		return entityManager.createQuery(jpql,Alumno.class)
			.setParameter("c", curso)
			.getResultList();

	}

	@Transactional
	@Override
	public void alta(Alumno alumno) {
		if (!existeAlumno(alumno.getNombre())) {
			entityManager.persist(alumno);
		}
	}
	
	@Override
	public boolean existeAlumno(String nombre) {
		String jpql = "select a from Alumno a where a.nombre=:n";
		List<Alumno> alumnos = entityManager.createQuery(jpql, Alumno.class)
				.setParameter("n", nombre).getResultList();
		return (alumnos.size()>0);

		
	}

	@Override
	public List<String> cursos() {
		String jpql = "select distinct a.curso from Alumno a";
		return entityManager.createQuery(jpql,String.class).getResultList();

	}

}
