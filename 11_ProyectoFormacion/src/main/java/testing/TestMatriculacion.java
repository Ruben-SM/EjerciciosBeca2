package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class})

public class TestMatriculacion {
	
	@Autowired
	FormacionService service;
	
	@Test
	public void testMatricularAlumno() {
		service.matricularAlumno("test1", 1);
		assertEquals(1, service.cursoAlumno("test1").size());
		assertEquals(9, service.alumnosCurso("java 10").size());
	}
}
