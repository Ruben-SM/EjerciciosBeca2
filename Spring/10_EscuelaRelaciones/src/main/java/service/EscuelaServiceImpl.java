package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;

@Service
public class EscuelaServiceImpl implements EscuelaService {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Alumno> alumnoCurso(String nombre) {
		String jpql = "select a from Alumno a where a.curso.denominacion =?1";
		return entityManager.createQuery(jpql,Alumno.class)
				.setParameter(1, nombre)
				.getResultList();
		
	}

	@Override
	public List<Alumno> alumnosCursoDuracion(int duracionMax) {
		String jpql = "select a from Alumno a where a.curso.duracion <=?1";
		return entityManager.createQuery(jpql,Alumno.class)
				.setParameter(1, duracionMax)
				.getResultList();
	}

	@Override
	public Curso cursoMatriculadoAlumno(String dni) {
		String jpql = "select c from Curso c join c.alumnos a where a.dni=?1 ";
		List<Curso> cursos = entityManager.createQuery(jpql,Curso.class)
				.setParameter(1, dni)
				.getResultList();
		return cursos.size()>0 ? cursos.get(0) : null;
	}

	@Override
	public List<Curso> alumnosSenior(int edad) {
		String jpql = "select distinct (c) from Curso c join c.alumnos a where a.edad >=?1 ";
		return entityManager.createQuery(jpql,Curso.class)
				.setParameter(1,edad)
				.getResultList();
	}

	@Override
	public double edadMediaCurso(String nombreCurso) {
		String jpql="select avg(a.edad) from Alumno a where a.curso.denominacion =?1 ";
		return entityManager.createQuery(jpql,Double.class)
				.setParameter(1, nombreCurso)
				.getSingleResult();
	}

	@Override
	public double precioCurso(String email) {
		String jpql = "select c.precio from Curso c join c.alumnos a where a.email =?1";
		return entityManager.createQuery(jpql,Double.class)
				.setParameter(1, email)
				.getSingleResult();
	}

}
