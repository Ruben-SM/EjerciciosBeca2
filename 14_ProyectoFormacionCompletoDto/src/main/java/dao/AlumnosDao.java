package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;
											    // <Entidad, id>
public interface AlumnosDao extends JpaRepository<Alumno, String>{

	Alumno findByUsuarioAndPassword(String usuario, String password);
	
	@Query("select a from Alumno a join a.cursos c where c.nombre =?1")
	List<Alumno> findByCurso(String nombreCurso);
	

}