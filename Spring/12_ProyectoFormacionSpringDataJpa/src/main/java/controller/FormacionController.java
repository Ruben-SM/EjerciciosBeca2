package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {

	@Autowired
	FormacionService formacionService;
	
	
	@PostMapping("Login")
	public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String password, HttpSession sesion, HttpServletRequest request) {
		Alumno alumno = formacionService.validarUsuario(usuario, password);
		if (alumno!= null) {
			sesion.setAttribute("alumno", alumno);
			return "menu"; 
		}else {
			sesion.setAttribute("mensaje", "usuario y/o contraseña incorrectos");
			return "login";
		}
	}
	
	@GetMapping(value="Cursos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<Curso> cursos() {
		return formacionService.listaCursos();
	}
	
	@GetMapping(value="Alumnos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<Alumno> alumnos() {
		return formacionService.listaAlumnos();
	}
	
	
	@GetMapping(value="AlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<Alumno> alumnosCurso(@RequestParam("nombre") String curso) {
		return formacionService.alumnosCurso(curso);
	}
	
	
	@GetMapping(value="CursoAlumnos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<Curso> cursoAlumnos(@RequestParam("usuario") String usuario) {
		return formacionService.cursoAlumno(usuario);
	}
	


	
	
}
