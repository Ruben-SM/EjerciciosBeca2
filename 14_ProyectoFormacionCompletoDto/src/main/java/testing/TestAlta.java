package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import dtos.AlumnoDto;
import dtos.CursoDto;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class})
public class TestAlta {

	@Autowired
	FormacionService service;
	
	
	@Test
	public void testAltaUsuario() {
		AlumnoDto a = new AlumnoDto("juan", "1234", "juan", "juan@mail.com", 20);
		service.altaAlumno(a);
		assertEquals(a.getNombre(), service.validarUsuario("juan", "1234").getNombre());
	}
	
	@Test
	public void testAltaCurso() {
		Calendar cal = Calendar.getInstance();
		cal.set(2022, 6,20);
		Date f = cal.getTime();
		
		CursoDto c = new CursoDto("C++", 100, 100,f);
		assertTrue(service.altaCurso(c));

	}
	
	
}
