package dao;


import org.springframework.data.jpa.repository.JpaRepository;

import model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno, Integer>{
	// opcion 1: se le da la lista de cursos ya filtrada
	/*
	@Query("select distinct (a.curso) from Alumno a")
	List<String> findCursos();*/
	
	// opcion 2: no se hace el metodo anterior y la capa de servicio filtre a partir de la lista de cursos

}
