package testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import config.ServiceConfig;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class})
public class TestFormacionService {
	
	@Autowired
	FormacionService service;
	
	@Test
	public void testValidarUsuario() {
		assertEquals("tomates", service.validarUsuario("admin", "a").getNombre());
	}
	
	
	@Test
	public void testCursoAlumno() {
		assertEquals(4, service.cursoAlumno("admin").size());
	}
	
	
	@Test
	public void testListaCursos() {
		assertEquals(19, service.listaCursos().size());
	}
	
	
	@Test
	public void testAlumnosCurso() {
		assertEquals(1, service.alumnosCurso("php").size());
	}
	
	
	@Test
	public void testConsultaMatriculas() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2020, 0, 1);
		c2.set(2020, 11, 31);
		
		Date f1 = c1.getTime();
		Date f2 = c2.getTime();
		
		
		assertEquals(14, service.consultarMatriculas(f1, f2).size());
		
	}
	
	@Test
	public void testCursosPosiblesMatriculacion() {
		assertEquals(17, service.cursosPosiblesMatricularAlumno("aaa").size());
		
	}
	
	
}
