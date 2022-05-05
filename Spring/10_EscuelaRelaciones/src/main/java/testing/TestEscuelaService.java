package testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import config.ServiceConfig;
import service.EscuelaService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class})
public class TestEscuelaService {
	
	@Autowired
	EscuelaService service;
	
	@Test
	void testAlumnoCurso() {
		assertEquals(4, service.alumnoCurso("java").size());
	}
	
	@Test
	void testAlumnoCursoDuracion() {
		assertEquals(3, service.alumnosCursoDuracion(70).size());
	}
	
	@Test
	void testCursoMatriculadoAlumno() {
		assertEquals("java", service.cursoMatriculadoAlumno("223e").getDenominacion());
	}
	
	@Test
	void testAlumnosSenior() {
		assertEquals(2, service.alumnosSenior(30).size());
	}
	
	@Test
	void edadMediaCurso() {
		assertEquals(25, service.edadMediaCurso("java"));
	}
	
	
	@Test
	void testPrecioCurso() {
		assertEquals(250.0, service.precioCurso("primero@gmail.com"));
	}
	

}
