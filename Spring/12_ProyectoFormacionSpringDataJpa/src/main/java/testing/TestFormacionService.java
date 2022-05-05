package testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
	public void testValidarUsuarioNull() {
		assertEquals(null, service.validarUsuario("pepe", "a"));
	}
	
	@Test
	public void testCursoAlumno() {
		assertEquals(4, service.cursoAlumno("admin").size());
	}
	
	
	@Test
	public void testListaCursos() {
		assertEquals(18, service.listaCursos().size());
	}
	
	
	@Test
	public void testAlumnosCurso() {
		assertEquals(1, service.alumnosCurso("php").size());
	}
	
	
}
