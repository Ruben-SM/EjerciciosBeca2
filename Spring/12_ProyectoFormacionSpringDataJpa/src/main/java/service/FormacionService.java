package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	
	public Alumno validarUsuario(String usuario, String pass);
	public List<Curso> cursoAlumno(String usuario);
	public List<Curso> listaCursos();
	public List<Alumno> alumnosCurso(String nombreCurso);
	public boolean matricularAlumno(String usuario, int idCurso);
	
	public List<Alumno> listaAlumnos();

}
