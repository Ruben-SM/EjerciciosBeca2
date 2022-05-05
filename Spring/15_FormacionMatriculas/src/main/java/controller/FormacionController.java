package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dtos.AlumnoDto;
import dtos.CursoDto;
import dtos.MatriculaDto;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {

	@Autowired
	FormacionService formacionService;
	
	
	@PostMapping("Login")
	public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String password, HttpSession sesion, HttpServletRequest request) {
		AlumnoDto alumno = formacionService.validarUsuario(usuario, password);
		if (alumno!= null) {
			sesion.setAttribute("alumno", alumno);
			return "menu"; 
		}else {
			sesion.setAttribute("mensaje", "usuario y/o contraseña incorrectos");
			return "login";
		}
	}
	
	@GetMapping(value="Cursos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<CursoDto> cursos() {
		return formacionService.listaCursos();
	}
	
	@GetMapping(value="Alumnos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<AlumnoDto> alumnos() {
		return formacionService.listaAlumnos();
	}
	
	
	@GetMapping(value="AlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<AlumnoDto> alumnosCurso(@RequestParam("nombre") String curso) {
		return formacionService.alumnosCurso(curso);
	}
	
	
	@GetMapping(value="CursoAlumnos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<CursoDto> cursoAlumnos(@RequestParam("usuario") String usuario) {
		return formacionService.cursoAlumno(usuario);
	}
	
	@PostMapping(value="AltaAlumno")
	public String altaAlumno(@ModelAttribute AlumnoDto alumno) {
		return  (formacionService.altaAlumno(alumno))? "menu" : "AltaAlumno";
	}
	
	@PostMapping(value = "AltaCurso")
	public String altaCurso(@ModelAttribute CursoDto curso, @DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("fecha") Date fecha) {
		curso.setFechaInicio(fecha);
		return (formacionService.altaCurso(curso))? "menu" : "AltaCurso";
	}
	
	@GetMapping(value="Matriculas", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<MatriculaDto> cursosEntreFechas(@DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("fechaIni") Date fechaIni,
														@DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("fechaFin") Date fechaFin){
		
		return formacionService.consultarMatriculas(fechaIni, fechaFin);
	}
	
	
	@GetMapping(value="CursosPosibles", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<CursoDto> cursosNoAlumnos(@RequestParam("usuario") String usuario){
		return formacionService.cursosPosiblesMatricularAlumno(usuario);
		
	}
	
	
	@PostMapping(value="Matricular")
	public String matricular(@RequestParam("idCurso") int idCurso, @RequestParam("usuario") String usuario) {
		formacionService.matricularAlumno(usuario, idCurso);
		return "menu";
	}
	


	
	
}
