package service;

import java.util.List;

import model.Alumno;

public interface AlumnoService {

	List<Alumno> buscarCurso(String curso);
	void alta(Alumno producto);
	boolean existeAlumno(String nombre);
	List<String> cursos();
}
