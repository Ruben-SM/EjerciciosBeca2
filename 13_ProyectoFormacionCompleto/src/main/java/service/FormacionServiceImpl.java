package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {

	
	AlumnosDao alumnosDao;
	CursosDao cursosDao;
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao ) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
	}
	
	@Override
	public Alumno validarUsuario(String usuario, String pass) {
		return alumnosDao.findByUsuarioAndPassword(usuario, pass);
	}

	@Override
	public List<Curso> cursoAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> listaCursos() {
		return cursosDao.findAll();
	}

	@Override
	public List<Alumno> alumnosCurso(String nombreCurso) {
		return alumnosDao.findByCurso(nombreCurso);
	}

	
	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
	/*	
		Alumno alumno = alumnosDao.findById(usuario).orElse(null);
		Curso curso = cursosDao.findById(idCurso).orElse(null);
		
		if (alumno != null && curso != null) {
			alumno.getCursos().add(curso);
			alumnosDao.save(alumno);
			return true;
		}
		return false;
		*/
		
		Optional<Alumno> alumno = alumnosDao.findById(usuario);
		Optional<Curso> curso = cursosDao.findById(idCurso);
		
		if (curso.isPresent() && alumno.isPresent()) {
			Alumno al = alumno.get();
			Curso c = curso.get();
			
			al.getCursos().add(c);
			alumnosDao.save(al);
			return true;
		}
		return false;
	}

	@Override
	public List<Alumno> listaAlumnos() {
		return alumnosDao.findAll();
	}

	@Override
	public boolean altaAlumno(Alumno alumno) {
		if (alumnosDao.findById(alumno.getUsuario()).isEmpty()) {
			alumnosDao.save(alumno);
			return true;
		}
		
		return false;
			
	}

	@Override
	public boolean altaCurso(Curso curso) {
		if(cursosDao.findByNombre(curso.getNombre()).isEmpty()) {
			cursosDao.save(curso);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Curso> consultarMatriculas(Date f1, Date f2) {
		return cursosDao.findByFechaInicioBetween(f1, f2);
	}

	@Override
	public List<Curso> cursosPosiblesMatricularAlumno(String usuario) {
		return cursosDao.findByAlumnoNoMatriculadoEn(usuario);
	}

}
