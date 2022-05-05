package dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;
	

}
