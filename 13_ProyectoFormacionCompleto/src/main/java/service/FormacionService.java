package service;

import java.util.Date;
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
	
	public boolean altaAlumno(Alumno alumno);
	public boolean altaCurso(Curso curso);
	List<Curso> consultarMatriculas (Date f1, Date f2);
	List<Curso> cursosPosiblesMatricularAlumno(String usuario);

}
