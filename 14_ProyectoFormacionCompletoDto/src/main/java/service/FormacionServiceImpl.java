package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.AlumnosDao;
import dao.CursosDao;
import dtos.AlumnoDto;
import dtos.CursoDto;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	ConversorEntityDto conversor;
	
	AlumnosDao alumnosDao;
	CursosDao cursosDao;
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao ) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
	}
	
	@Override
	public AlumnoDto validarUsuario(String usuario, String pass) {
		return conversor.alumnoToDto(alumnosDao.findByUsuarioAndPassword(usuario, pass));
	}

	@Override
	public List<CursoDto> cursoAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario)
				.stream()
				.map(c-> conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> listaCursos() {
		return cursosDao.findAll()
				.stream()
				.map(c-> conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<AlumnoDto> alumnosCurso(String nombreCurso) {
		return alumnosDao.findByCurso(nombreCurso)
				.stream()
				.map(a-> conversor.alumnoToDto(a))
				.collect(Collectors.toList());
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
	public List<AlumnoDto> listaAlumnos() {
		return alumnosDao.findAll()
				.stream()
				.map(a-> conversor.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public boolean altaAlumno(AlumnoDto alumno) {
		if (alumnosDao.findById(alumno.getUsuario()).isEmpty()) {
			alumnosDao.save(conversor.dtoToAlumno(alumno));
			return true;
		}
		
		return false;
			
	}

	@Override
	public boolean altaCurso(CursoDto curso) {
		if(cursosDao.findByNombre(curso.getNombre()).isEmpty()) {
			cursosDao.save(conversor.dtoToCurso(curso));
			return true;
		}
		
		return false;
	}

	@Override
	public List<CursoDto> consultarMatriculas(Date f1, Date f2) {
		return cursosDao.findByFechaInicioBetween(f1, f2)
				.stream()
				.map(c-> conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> cursosPosiblesMatricularAlumno(String usuario) {
		return cursosDao.findByAlumnoNoMatriculadoEn(usuario)
				.stream()
				.map(c-> conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

}
