package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import service.AlumnoService;

@CrossOrigin("*")
@Controller
public class AlumnoController {

	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping(value="Cursos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<String> cursos() {
		return alumnoService.cursos();
	}
	
	@GetMapping(value="Buscador", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> buscar(@RequestParam("curso") String curso, HttpServletRequest request) {
		return alumnoService.buscarCurso(curso);
	}
	
	@PostMapping("Alta")
	public String alta(@ModelAttribute Alumno alumno) {
		if (!alumnoService.existeAlumno(alumno.getNombre())) {
			alumnoService.alta(alumno);
			return "inicio";
		}else {
			return "error";
		}
		
	}
	
	
}
