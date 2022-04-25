package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface EscuelaService {
	List<Alumno> alumnoCurso(String nombre);
	List<Alumno> alumnosCursoDuracion(int duracionMax);
	Curso cursoMatriculadoAlumno(String dni);
	List<Curso> alumnosSenior(int edad);	// lista de cursos en los que estan matriculados alumnos con edad superior al valor recibido
	
	// devuelve la edad media de los alumnos matriculados en el curso indicado por parametro
	double edadMediaCurso(String nombreCurso);
	
	// devuelve el precio del curso en el que esta matriculado el alumno cuyo email se recibe
	double precioCurso(String email);
	

}
