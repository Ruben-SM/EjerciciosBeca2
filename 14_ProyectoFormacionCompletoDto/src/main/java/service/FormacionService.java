package service;

import java.util.Date;
import java.util.List;

import dtos.AlumnoDto;
import dtos.CursoDto;

public interface FormacionService {
	
	public AlumnoDto validarUsuario(String usuario, String pass);
	public List<CursoDto> cursoAlumno(String usuario);
	public List<CursoDto> listaCursos();
	public List<AlumnoDto> alumnosCurso(String nombreCurso);
	public boolean matricularAlumno(String usuario, int idCurso);	
	public List<AlumnoDto> listaAlumnos();
	
	public boolean altaAlumno(AlumnoDto alumno);
	public boolean altaCurso(CursoDto curso);
	List<CursoDto> consultarMatriculas (Date f1, Date f2);
	List<CursoDto> cursosPosiblesMatricularAlumno(String usuario);

}
