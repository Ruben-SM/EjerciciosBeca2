package dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CursoDto {

	private int idCurso;
	private String nombre;
	private int duracion;
	private double precio;	
	private Date fechaInicio;
	List<String> alumnos;
	
	public CursoDto(String nombre, int duracion, double precio, Date fechaInicio) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
	}
	
	

}
